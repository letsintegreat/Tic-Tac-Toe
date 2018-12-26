package com.coolgame.zlytherin.game.tic_tac_toe;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.TurnBasedMultiplayerClient;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchUpdateCallback;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class MultiplayerActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 123;
    private static final int RC_SELECT_PLAYERS = 9010;
    private static final int RC_JOIN_MATCH = 321;

    private TurnBasedMultiplayerClient turnBasedMultiplayerClient;
    private String myPlayerId, myParticipantId, nextParticipantId;
    private TurnBasedMatch mMatch;
    private byte[] gameStatus;
    private String sGameStatus;

    private boolean isGameRunning = true, myTurn;
    private Handler handler;
    private int varButton1 = 2, varButton2 = 2, varButton3 = 2, varButton4 = 2, varButton5 = 2,
            varButton6 = 2, varButton7 = 2, varButton8 = 2, varButton9 = 2, turn = 0, player = 1;
    private Dialog myDialog, exitDialog, joinDialog;
    private TextView dialogTxt, head, exitDialogTxt, joinDialogTxt;
    private Button playAgain, exit, exitDialogExit, exitDialogAgain, joinDialogAdd, joinDialogJoin;
    private ImageView viewForButton1, viewForButton2, viewForButton3, viewForButton4, viewForButton5,
            viewForButton6, viewForButton7, viewForButton8, viewForButton9, backImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);

        handler = new Handler();

        backImage = (ImageView) findViewById(R.id.back_image);
        exitDialog = new Dialog(this);
        exitDialog.setContentView(R.layout.match_over);
        exitDialogTxt = exitDialog.findViewById(R.id.txt_declare);
        exitDialogAgain = exitDialog.findViewById(R.id.button_again);
        exitDialogExit = exitDialog.findViewById(R.id.button_exit);
        exitDialogTxt.setText("Are you sure?");
        exitDialogAgain.setText("Continue");
        exitDialogExit.setText("Exit game");
        joinDialog = new Dialog(this);
        joinDialog.setContentView(R.layout.match_over);
        joinDialogTxt = joinDialog.findViewById(R.id.txt_declare);
        joinDialogAdd = joinDialog.findViewById(R.id.button_again);
        joinDialogJoin = joinDialog.findViewById(R.id.button_exit);
        joinDialogTxt.setText("Play Multiplayer");
        joinDialogAdd.setText("Add");
        joinDialogJoin.setText("Join");

        joinDialogAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turnBasedMultiplayerClient
                        .getSelectOpponentsIntent(1, 1, false)
                        .addOnSuccessListener(new OnSuccessListener<Intent>() {
                            @Override
                            public void onSuccess(Intent intent) {
                                startActivityForResult(intent, RC_SELECT_PLAYERS);
                            }
                        });
                joinDialog.dismiss();
            }
        });

        joinDialogJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                turnBasedMultiplayerClient.getInboxIntent()
                        .addOnSuccessListener(new OnSuccessListener<Intent>() {
                            @Override
                            public void onSuccess(Intent intent) {
                                startActivityForResult(intent, RC_JOIN_MATCH);
                            }
                        });
                joinDialog.dismiss();
            }
        });

        joinDialog.show();

        viewForButton1 = (ImageView) findViewById(R.id.idButton1);
        viewForButton2 = (ImageView) findViewById(R.id.idButton2);
        viewForButton3 = (ImageView) findViewById(R.id.idButton3);
        viewForButton4 = (ImageView) findViewById(R.id.idButton4);
        viewForButton5 = (ImageView) findViewById(R.id.idButton5);
        viewForButton6 = (ImageView) findViewById(R.id.idButton6);
        viewForButton7 = (ImageView) findViewById(R.id.idButton7);
        viewForButton8 = (ImageView) findViewById(R.id.idButton8);
        viewForButton9 = (ImageView) findViewById(R.id.idButton9);

        viewForButton1.animate().alpha(0).translationX(130);
        viewForButton2.animate().alpha(0).translationX(130);
        viewForButton3.animate().alpha(0).translationX(130);
        viewForButton4.animate().alpha(0).translationX(130);
        viewForButton5.animate().alpha(0).translationX(130);
        viewForButton6.animate().alpha(0).translationX(130);
        viewForButton7.animate().alpha(0).translationX(130);
        viewForButton8.animate().alpha(0).translationX(130);
        viewForButton9.animate().alpha(0).translationX(130);

        head = (TextView) findViewById(R.id.head);
        myDialog = new Dialog(this);

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitDialog.show();
                exitDialogAgain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        exitDialog.dismiss();
                    }
                });

                exitDialogExit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        turnBasedMultiplayerClient.leaveMatch(mMatch.getMatchId());
                        finish();
                        exitDialog.dismiss();
                    }
                });
            }
        });

        ((LinearLayout) findViewById(R.id.llButton1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGameRunning) {
                    button1();
                }
            }
        });

        ((LinearLayout) findViewById(R.id.llButton2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGameRunning) {
                    button2();
                }
            }
        });

        ((LinearLayout) findViewById(R.id.llButton3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGameRunning) {
                    button3();
                }
            }
        });

        ((LinearLayout) findViewById(R.id.llButton4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGameRunning) {
                    button4();
                }
            }
        });

        ((LinearLayout) findViewById(R.id.llButton5)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGameRunning) {
                    button5();
                }
            }
        });

        ((LinearLayout) findViewById(R.id.llButton6)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGameRunning) {
                    button6();
                }
            }
        });

        ((LinearLayout) findViewById(R.id.llButton7)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGameRunning) {
                    button7();
                }
            }
        });

        ((LinearLayout) findViewById(R.id.llButton8)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGameRunning) {
                    button8();
                }
            }
        });

        ((LinearLayout) findViewById(R.id.llButton9)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGameRunning) {
                    button9();
                }
            }
        });
    }

    public void button1() {
        if (varButton1 == 2 && myTurn) {
            if (turn == 0) {
                varButton1 = 0;
                viewForButton1.setImageResource(R.drawable.o);
                viewForButton1.animate().alpha(1).translationX(0).rotation(360);
                turn = 1;
            } else {
                varButton1 = 1;
                viewForButton1.setImageResource(R.drawable.x);
                viewForButton1.animate().alpha(1).translationX(0).rotation(360);
                turn = 0;
            }
            if (player != turn) {
                sGameStatus += '1';
                gameStatus = sGameStatus.getBytes();
                turnBasedMultiplayerClient.takeTurn(mMatch.getMatchId(),
                        gameStatus,
                        nextParticipantId);
                showTurnUI(mMatch);
                myTurn = !myTurn;
            }
        }
        winnerCheck();
    }

    public void button2() {
        if (varButton2 == 2 && myTurn) {
            if (turn == 0) {
                varButton2 = 0;
                viewForButton2.setImageResource(R.drawable.o);
                viewForButton2.animate().alpha(1).translationX(0).rotation(360);
                turn = 1;
            } else {
                varButton2 = 1;
                viewForButton2.setImageResource(R.drawable.x);
                viewForButton2.animate().alpha(1).translationX(0).rotation(360);
                turn = 0;
            }
            if (player != turn) {
                sGameStatus += '2';
                gameStatus = sGameStatus.getBytes();
                turnBasedMultiplayerClient.takeTurn(mMatch.getMatchId(),
                        gameStatus,
                        nextParticipantId);
                showTurnUI(mMatch);
                myTurn = !myTurn;
            }
        }
        winnerCheck();
    }

    public void button3() {
        if (varButton3 == 2 && myTurn) {
            if (turn == 0) {
                varButton3 = 0;
                viewForButton3.setImageResource(R.drawable.o);
                viewForButton3.animate().alpha(1).translationX(0).rotation(360);
                turn = 1;
            } else {
                varButton3 = 1;
                viewForButton3.setImageResource(R.drawable.x);
                viewForButton3.animate().alpha(1).translationX(0).rotation(360);
                turn = 0;
            }
            if (player != turn) {
                sGameStatus += '3';
                gameStatus = sGameStatus.getBytes();
                turnBasedMultiplayerClient.takeTurn(mMatch.getMatchId(),
                        gameStatus,
                        nextParticipantId);
                showTurnUI(mMatch);
                myTurn = !myTurn;
            }
        }
        winnerCheck();
    }

    public void button4() {
        if (varButton4 == 2 && myTurn) {
            if (turn == 0) {
                varButton4 = 0;
                viewForButton4.setImageResource(R.drawable.o);
                viewForButton4.animate().alpha(1).translationX(0).rotation(360);
                turn = 1;
            } else {
                varButton4 = 1;
                viewForButton4.setImageResource(R.drawable.x);
                viewForButton4.animate().alpha(1).translationX(0).rotation(360);
                turn = 0;
            }
            if (player != turn) {
                sGameStatus += '4';
                gameStatus = sGameStatus.getBytes();
                turnBasedMultiplayerClient.takeTurn(mMatch.getMatchId(),
                        gameStatus,
                        nextParticipantId);
                showTurnUI(mMatch);
                myTurn = !myTurn;
            }
        }
        winnerCheck();
    }

    public void button5() {
        if (varButton5 == 2 && myTurn) {
            if (turn == 0) {
                varButton5 = 0;
                viewForButton5.setImageResource(R.drawable.o);
                viewForButton5.animate().alpha(1).translationX(0).rotation(360);
                turn = 1;
            } else {
                varButton5 = 1;
                viewForButton5.setImageResource(R.drawable.x);
                viewForButton5.animate().alpha(1).translationX(0).rotation(360);
                turn = 0;
            }
            if (player != turn) {
                sGameStatus += '5';
                gameStatus = sGameStatus.getBytes();
                turnBasedMultiplayerClient.takeTurn(mMatch.getMatchId(),
                        gameStatus,
                        nextParticipantId);
                showTurnUI(mMatch);
                myTurn = !myTurn;
            }
        }
        winnerCheck();
    }

    public void button6() {
        if (varButton6 == 2 && myTurn) {
            if (turn == 0) {
                varButton6 = 0;
                viewForButton6.setImageResource(R.drawable.o);
                viewForButton6.animate().alpha(1).translationX(0).rotation(360);
                turn = 1;
            } else {
                varButton6 = 1;
                viewForButton6.setImageResource(R.drawable.x);
                viewForButton6.animate().alpha(1).translationX(0).rotation(360);
                turn = 0;
            }
            if (player != turn) {
                sGameStatus += '6';
                gameStatus = sGameStatus.getBytes();
                turnBasedMultiplayerClient.takeTurn(mMatch.getMatchId(),
                        gameStatus,
                        nextParticipantId);
                showTurnUI(mMatch);
                myTurn = !myTurn;
            }
        }
        winnerCheck();
    }

    public void button7() {
        if (varButton7 == 2 && myTurn) {
            if (turn == 0) {
                varButton7 = 0;
                viewForButton7.setImageResource(R.drawable.o);
                viewForButton7.animate().alpha(1).translationX(0).rotation(360);
                turn = 1;
            } else {
                varButton7 = 1;
                viewForButton7.setImageResource(R.drawable.x);
                viewForButton7.animate().alpha(1).translationX(0).rotation(360);
                turn = 0;
            }
            if (player != turn) {
                sGameStatus += '7';
                gameStatus = sGameStatus.getBytes();
                turnBasedMultiplayerClient.takeTurn(mMatch.getMatchId(),
                        gameStatus,
                        nextParticipantId);
                showTurnUI(mMatch);
                myTurn = !myTurn;
            }
        }
        winnerCheck();
    }

    public void button8() {
        if (varButton8 == 2 && myTurn) {
            if (turn == 0) {
                varButton8 = 0;
                viewForButton8.setImageResource(R.drawable.o);
                viewForButton8.animate().alpha(1).translationX(0).rotation(360);
                turn = 1;
            } else {
                varButton8 = 1;
                viewForButton8.setImageResource(R.drawable.x);
                viewForButton8.animate().alpha(1).translationX(0).rotation(360);
                turn = 0;
            }
            if (player != turn) {
                sGameStatus += '8';
                gameStatus = sGameStatus.getBytes();
                turnBasedMultiplayerClient.takeTurn(mMatch.getMatchId(),
                        gameStatus,
                        nextParticipantId);
                showTurnUI(mMatch);
                myTurn = !myTurn;
            }
        }
        winnerCheck();
    }

    public void button9() {
        if (varButton9 == 2 && myTurn) {
            if (turn == 0) {
                varButton9 = 0;
                viewForButton9.setImageResource(R.drawable.o);
                viewForButton9.animate().alpha(1).translationX(0).rotation(360);
                turn = 1;
            } else {
                varButton9 = 1;
                viewForButton9.setImageResource(R.drawable.x);
                viewForButton9.animate().alpha(1).translationX(0).rotation(360);
                turn = 0;
            }
            if (player != turn) {
                sGameStatus += '9';
                gameStatus = sGameStatus.getBytes();
                turnBasedMultiplayerClient.takeTurn(mMatch.getMatchId(),
                        gameStatus,
                        nextParticipantId);
                showTurnUI(mMatch);
                myTurn = !myTurn;
            }
        }
        winnerCheck();
    }

    public void winnerCheck() {
        if (varButton1 == 1 && varButton2 == 1 && varButton3 == 1) {
            setWinner(varButton1);
        } else if (varButton4 == 1 && varButton5 == 1 && varButton6 == 1) {
            setWinner(varButton4);
        } else if (varButton7 == 1 && varButton8 == 1 && varButton9 == 1) {
            setWinner(varButton7);
        } else if (varButton1 == 1 && varButton5 == 1 && varButton9 == 1) {
            setWinner(varButton1);
        } else if (varButton7 == 1 && varButton5 == 1 && varButton3 == 1) {
            setWinner(varButton7);
        } else if (varButton1 == 1 && varButton4 == 1 && varButton7 == 1) {
            setWinner(varButton1);
        } else if (varButton2 == 1 && varButton5 == 1 && varButton8 == 1) {
            setWinner(varButton2);
        } else if (varButton3 == 1 && varButton6 == 1 && varButton9 == 1) {
            setWinner(varButton3);
        } else if (varButton1 == 0 && varButton2 == 0 && varButton3 == 0) {
            setWinner(varButton1);
        } else if (varButton4 == 0 && varButton5 == 0 && varButton6 == 0) {
            setWinner(varButton4);
        } else if (varButton7 == 0 && varButton8 == 0 && varButton9 == 0) {
            setWinner(varButton7);
        } else if (varButton1 == 0 && varButton5 == 0 && varButton9 == 0) {
            setWinner(varButton1);
        } else if (varButton7 == 0 && varButton5 == 0 && varButton3 == 0) {
            setWinner(varButton7);
        } else if (varButton1 == 0 && varButton4 == 0 && varButton7 == 0) {
            setWinner(varButton1);
        } else if (varButton2 == 0 && varButton5 == 0 && varButton8 == 0) {
            setWinner(varButton2);
        } else if (varButton3 == 0 && varButton6 == 0 && varButton9 == 0) {
            setWinner(varButton3);
        } else if (varButton1 != 2 && varButton2 != 2 && varButton3 != 2 && varButton4 != 2 && varButton5 != 2 && varButton6 != 2 && varButton7 != 2 && varButton8 != 2 && varButton9 != 2) {
            setWinner(2);
        }
    }

    public void setWinner(int winner) {
        myDialog.setContentView(R.layout.match_over);
        dialogTxt = (TextView) myDialog.findViewById(R.id.txt_declare);
        playAgain = (Button) myDialog.findViewById(R.id.button_again);
        exit = (Button) myDialog.findViewById(R.id.button_exit);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                myDialog.show();
            }
        }, 1000);
        if (winner == player) {
            dialogTxt.setText("You wins!");
            isGameRunning = false;
        } else if (winner != player) {
            dialogTxt.setText("You lose!");
            isGameRunning = false;
        } else {
            dialogTxt.setText("Match draw!");
            isGameRunning = false;
        }

        turnBasedMultiplayerClient.finishMatch(mMatch.getMatchId());
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                myDialog.dismiss();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory( Intent.CATEGORY_HOME );
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                finish();
                myDialog.dismiss();
            }
        });
    }

    private void signInSilently() {
        GoogleSignInClient signInClient = GoogleSignIn.getClient(this,
                GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN);
        signInClient.silentSignIn().addOnCompleteListener(this,
                new OnCompleteListener<GoogleSignInAccount>() {
                    @Override
                    public void onComplete(@NonNull Task<GoogleSignInAccount> task) {
                        if (!task.isSuccessful()) {
                            // Player will need to sign-in explicitly using via UI
                            startSignInIntent();
                        } else {
                            turnBasedMultiplayerClient = Games.getTurnBasedMultiplayerClient(
                                    MultiplayerActivity.this, GoogleSignIn.getLastSignedInAccount(MultiplayerActivity.this));
                            Games.getPlayersClient(MultiplayerActivity.this,
                                    GoogleSignIn.getLastSignedInAccount(MultiplayerActivity.this))
                                    .getCurrentPlayer()
                                    .addOnSuccessListener(new OnSuccessListener<Player>() {
                                        @Override
                                        public void onSuccess(Player player) {
                                            myPlayerId = player.getPlayerId();
                                        }
                                    });
                            turnBasedMultiplayerClient.registerTurnBasedMatchUpdateCallback(mMatchUpdateCallback);
                        }
                    }
                });
    }

    private void startSignInIntent() {
        GoogleSignInClient signInClient = GoogleSignIn.getClient(this,
                GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN);
        Intent intent = signInClient.getSignInIntent();
        startActivityForResult(intent, RC_SIGN_IN);
    }

    private void showTurnUI(TurnBasedMatch match) {
        if (match.getTurnStatus() == TurnBasedMatch.MATCH_TURN_STATUS_MY_TURN) {
            head.setText("Your Turn");
        } else {
            head.setText("Opponent's Turn");
        }
    }

    private TurnBasedMatchUpdateCallback mMatchUpdateCallback = new TurnBasedMatchUpdateCallback() {
        @Override
        public void onTurnBasedMatchReceived(@NonNull TurnBasedMatch turnBasedMatch) {
            mMatch = turnBasedMatch;
            gameStatus = mMatch.getData();
            showTurnUI(mMatch);
            try {
                sGameStatus = new String(gameStatus, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Toast.makeText(MultiplayerActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                finish();
            } catch (NullPointerException ex) {
                sGameStatus = "";
            }
            char lastInput;
            try {
                lastInput = sGameStatus.charAt(sGameStatus.length() - 1);
            } catch (IndexOutOfBoundsException ex) {
                lastInput = '0';
            }
            if (lastInput == '1') {
                button1();
            } else if (lastInput == '2') {
                button2();
            } else if (lastInput == '3') {
                button3();
            } else if (lastInput == '4') {
                button4();
            } else if (lastInput == '5') {
                button5();
            } else if (lastInput == '6') {
                button6();
            } else if (lastInput == '7') {
                button7();
            } else if (lastInput == '8') {
                button8();
            } else if (lastInput == '9') {
                button9();
            }
            myTurn = true;
        }
        @Override
        public void onTurnBasedMatchRemoved(@NonNull String s) {
            if (mMatch.getMatchId().equals(s)) {
                new AlertDialog.Builder(MultiplayerActivity.this).setMessage("Opponent Left")
                        .setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                turnBasedMultiplayerClient.dismissMatch(mMatch.getMatchId());
                                finish();
                            }
                        }).show();
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        signInSilently();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (!result.isSuccess()) {
                String message = result.getStatus().getStatusMessage();
                if (message == null || message.isEmpty()) {
                    message = "Login Failed";
                }
                new AlertDialog.Builder(this).setMessage(message)
                        .setNeutralButton(android.R.string.ok, null).show();
                finish();
            } else {
                turnBasedMultiplayerClient = Games.getTurnBasedMultiplayerClient(
                        MultiplayerActivity.this, GoogleSignIn.getLastSignedInAccount(MultiplayerActivity.this));

                Games.getPlayersClient(MultiplayerActivity.this,
                        GoogleSignIn.getLastSignedInAccount(MultiplayerActivity.this))
                        .getCurrentPlayer()
                        .addOnSuccessListener(new OnSuccessListener<Player>() {
                            @Override
                            public void onSuccess(Player player) {
                                myPlayerId = player.getPlayerId();
                            }
                        });
                turnBasedMultiplayerClient.registerTurnBasedMatchUpdateCallback(mMatchUpdateCallback);
            }
        } else if (requestCode == RC_SELECT_PLAYERS) {
            if (resultCode != Activity.RESULT_OK) {
                new AlertDialog.Builder(this).setMessage("Error Occurred")
                        .setNeutralButton(android.R.string.ok, null).show();
                finish();
                return;
            }
            ArrayList<String> invitees = data.getStringArrayListExtra(Games.EXTRA_PLAYER_IDS);

            Bundle autoMatchCriteria = null;
            int minAutoPlayers = data.getIntExtra(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, 1);
            int maxAutoPlayers = data.getIntExtra(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, 1);

            TurnBasedMatchConfig.Builder builder = TurnBasedMatchConfig.builder()
                    .addInvitedPlayers(invitees);
            if (minAutoPlayers > 0) {
                builder.setAutoMatchCriteria(
                        RoomConfig.createAutoMatchCriteria(minAutoPlayers, maxAutoPlayers, 0));
            }

            turnBasedMultiplayerClient
                    .createMatch(builder.build()).addOnCompleteListener(new OnCompleteListener<TurnBasedMatch>() {
                @Override
                public void onComplete(@NonNull Task<TurnBasedMatch> task) {
                    if (task.isSuccessful()) {
                        TurnBasedMatch match = task.getResult();
                        mMatch = match;
                        myTurn = false;
                        gameStatus = mMatch.getData();
                        try {
                            sGameStatus = new String(gameStatus, "UTF-8");
                        } catch (UnsupportedEncodingException ex) {
                            Toast.makeText(MultiplayerActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                            finish();
                        } catch (NullPointerException ex) {
                            sGameStatus = "";
                        }
                        myParticipantId = match.getParticipantId(myPlayerId);
                        nextParticipantId = "";
                        ArrayList<String> participantsIds = match.getParticipantIds();
                        for (String id: participantsIds) {
                            if (!id.equals(myParticipantId)) {
                                nextParticipantId = id;
                            }
                        }
                        turnBasedMultiplayerClient.takeTurn(match.getMatchId(), "".getBytes(),
                                nextParticipantId);
                        Toast.makeText(MultiplayerActivity.this, "Turn taken", Toast.LENGTH_SHORT).show();
                        showTurnUI(match);
                    } else {
                        // There was an error. Show the error.
                        int status = CommonStatusCodes.DEVELOPER_ERROR;
                        Exception exception = task.getException();
                        if (exception instanceof ApiException) {
                            ApiException apiException = (ApiException) exception;
                            status = apiException.getStatusCode();
                        }
                    }
                }
            });
        } else if (requestCode == RC_JOIN_MATCH) {
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                TurnBasedMatch newMatch = data.getParcelableExtra(Multiplayer.EXTRA_TURN_BASED_MATCH);
                mMatch = newMatch;
                gameStatus = mMatch.getData();
                try {
                    sGameStatus = new String(gameStatus, "UTF-8");
                } catch (UnsupportedEncodingException ex) {
                    Toast.makeText(MultiplayerActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                    finish();
                } catch (NullPointerException ex) {
                    sGameStatus = "";
                }
                myParticipantId = newMatch.getParticipantId(myPlayerId);
                nextParticipantId = "";
                myTurn = true;
                player = 0;
                ArrayList<String> participantIds = newMatch.getParticipantIds();
                for (String id: participantIds) {
                    if (!id.equals(myParticipantId)) {
                        nextParticipantId = id;
                    }
                }
                showTurnUI(newMatch);
            }
        }
    }
}
