package com.coolgame.zlytherin.game.tic_tac_toe;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private boolean isGameRunning = true;
    private Handler handler;
    private final ArrayList<Integer> userTurn = new ArrayList<>();
    private int varButton1 = 2, varButton2 = 2, varButton3 = 2, varButton4 = 2, varButton5 = 2,
            varButton6 = 2, varButton7 = 2, varButton8 = 2, varButton9 = 2, phase = 1,
            player, turn = 0, userTurnCount = 0;
    private Dialog myDialog, exitDialog;
    private TextView head;
    private Button exitDialogExit;
    private Button exitDialogAgain;
    private ImageView viewForButton1;
    private ImageView viewForButton2;
    private ImageView viewForButton3;
    private ImageView viewForButton4;
    private ImageView viewForButton5;
    private ImageView viewForButton6;
    private ImageView viewForButton7;
    private ImageView viewForButton8;
    private ImageView viewForButton9;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        player = getIntent().getExtras().getInt("MODE_TYPE");
        handler = new Handler();

        ImageView backImage = (ImageView) findViewById(R.id.back_image);
        exitDialog = new Dialog(this);
        exitDialog.setContentView(R.layout.match_over);
        TextView exitDialogTxt = exitDialog.findViewById(R.id.txt_declare);
        exitDialogAgain = exitDialog.findViewById(R.id.button_again);
        exitDialogExit = exitDialog.findViewById(R.id.button_exit);
        exitDialogTxt.setText("Are you sure?");
        exitDialogAgain.setText("Continue");
        exitDialogExit.setText("Exit game");

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
                    if (player == 1) {
                        computerTurn();
                    }
                    if (player == 2) {
                        toggleActionBar();
                    }
                }
            }
        });

        ((LinearLayout) findViewById(R.id.llButton2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGameRunning) {
                    button2();
                    if (player == 1) {
                        computerTurn();
                    }
                    if (player == 2) {
                        toggleActionBar();
                    }
                }
            }
        });

        ((LinearLayout) findViewById(R.id.llButton3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGameRunning) {
                    button3();
                    if (player == 1) {
                        computerTurn();
                    }
                    if (isGameRunning && player == 2) {
                        toggleActionBar();
                    }
                }
            }
        });

        ((LinearLayout) findViewById(R.id.llButton4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGameRunning) {
                    button4();
                    if (player == 1) {
                        computerTurn();
                    }
                    if (player == 2) {
                        toggleActionBar();
                    }
                }
            }
        });

        ((LinearLayout) findViewById(R.id.llButton5)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGameRunning) {
                    button5();
                    if (player == 1) {
                        computerTurn();
                    }
                    if (player == 2) {
                        toggleActionBar();
                    }
                }
            }
        });

        ((LinearLayout) findViewById(R.id.llButton6)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGameRunning) {
                    button6();
                    if (player == 1) {
                        computerTurn();
                    }
                    if (player == 2) {
                        toggleActionBar();
                    }
                }
            }
        });

        ((LinearLayout) findViewById(R.id.llButton7)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGameRunning) {
                    button7();
                    if (player == 1) {
                        computerTurn();
                    }
                    if (player == 2) {
                        toggleActionBar();
                    }
                }
            }
        });

        ((LinearLayout) findViewById(R.id.llButton8)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGameRunning) {
                    button8();
                    if (player == 1) {
                        computerTurn();
                    }
                    if (player == 2) {
                        toggleActionBar();
                    }
                }
            }
        });

        ((LinearLayout) findViewById(R.id.llButton9)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGameRunning) {
                    button9();
                    if (player == 1) {
                        computerTurn();
                    }
                    if (player == 2) {
                        toggleActionBar();
                    }
                }
            }
        });
    }

    public void button1() {
        if (turn != 0) {
            turn = 0;
            if (phase == 2) {
                viewForButton7.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton7.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton7 = 1;
            } else if (phase == 3) {
                viewForButton9.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton9.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton9 = 1;
            } else if (phase == 4) {
                viewForButton3.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton3.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton3 = 1;
            } else {
                if (varButton1 == 2) {
                    viewForButton1.setImageResource(R.drawable.x);
                    if (player == 1) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                viewForButton1.animate().alpha(1).translationX(0).rotation(360);
                            }
                        }, 500);
                    } else {
                        viewForButton1.animate().alpha(1).translationX(0).rotation(360);
                    }
                    varButton1 = 1;
                } else {
                    turn = 1;
                }
            }
        } else if (varButton1 == 2) {
            varButton1 = 0;
            viewForButton1.setImageResource(R.drawable.o);
            viewForButton1.animate().alpha(1).translationX(0).rotation(360);
            turn = 1;
            userTurnCount++;
            if (phase == 2) {
                userTurn.add(3);
            } else if (phase == 3) {
                userTurn.add(9);
            } else if (phase == 4) {
                userTurn.add(7);
            } else {
                userTurn.add(1);
            }
        }
        winnerCheck();
    }

    public void button2() {
        if (turn != 0) {
            turn = 0;
            if (phase == 2) {
                viewForButton4.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton4.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton4 = 1;
            } else if (phase == 3) {
                viewForButton8.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton8.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton8 = 1;
            } else if (phase == 4) {
                viewForButton6.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton6.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton6 = 1;
            } else {
                if (varButton2 == 2) {
                    viewForButton2.setImageResource(R.drawable.x);
                    if (player == 1) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                viewForButton2.animate().alpha(1).translationX(0).rotation(360);
                            }
                        }, 500);
                    } else {
                        viewForButton2.animate().alpha(1).translationX(0).rotation(360);
                    }
                    varButton2 = 1;
                } else {
                    turn = 1;
                }
            }
        } else if (varButton2 == 2) {
            varButton2 = 0;
            viewForButton2.setImageResource(R.drawable.o);
            viewForButton2.animate().alpha(1).translationX(0).rotation(360);
            turn = 1;
            userTurnCount++;
            if (phase == 2) {
                userTurn.add(6);
            } else if (phase == 3) {
                userTurn.add(8);
            } else if (phase == 4) {
                userTurn.add(4);
            } else {
                userTurn.add(2);
            }
        }
        winnerCheck();
    }

    public void button3() {
        if (turn != 0) {
            turn = 0;
            if (phase == 2) {
                viewForButton1.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton1.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton1 = 1;
            } else if (phase == 3) {
                viewForButton7.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton7.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton7 = 1;
            } else if (phase == 4) {
                viewForButton9.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton9.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton4 = 1;
            } else {
                if (varButton3 == 2) {
                    viewForButton3.setImageResource(R.drawable.x);
                    if (player == 1) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                viewForButton3.animate().alpha(1).translationX(0).rotation(360);
                            }
                        }, 500);
                    } else {
                        viewForButton3.animate().alpha(1).translationX(0).rotation(360);
                    }
                    varButton3 = 1;
                } else {
                    turn = 1;
                }
            }
        } else if (varButton3 == 2) {
            varButton3 = 0;
            viewForButton3.setImageResource(R.drawable.o);
            viewForButton3.animate().alpha(1).translationX(0).rotation(360);
            turn = 1;
            userTurnCount++;
            if (phase == 2) {
                userTurn.add(9);
            } else if (phase == 3) {
                userTurn.add(7);
            } else if (phase == 4) {
                userTurn.add(1);
            } else {
                userTurn.add(3);
            }
        }
        winnerCheck();
    }

    public void button4() {
        if (turn != 0) {
            turn = 0;
            if (phase == 2) {
                viewForButton8.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton8.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton8 = 1;
            } else if (phase == 3) {
                viewForButton6.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton6.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton6 = 1;
            } else if (phase == 4) {
                viewForButton2.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton2.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton2 = 1;
            } else {
                if (varButton4 == 2) {
                    viewForButton4.setImageResource(R.drawable.x);
                    if (player == 1) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                viewForButton4.animate().alpha(1).translationX(0).rotation(360);
                            }
                        }, 500);
                    } else {
                        viewForButton4.animate().alpha(1).translationX(0).rotation(360);
                    }
                    varButton4 = 1;
                } else {
                    turn = 1;
                }
            }
        } else if (varButton4 == 2) {
            varButton4 = 0;
            viewForButton4.setImageResource(R.drawable.o);
            viewForButton4.animate().alpha(1).translationX(0).rotation(360);
            turn = 1;
            userTurnCount++;
            if (phase == 2) {
                userTurn.add(2);
            } else if (phase == 3) {
                userTurn.add(6);
            } else if (phase == 4) {
                userTurn.add(8);
            } else {
                userTurn.add(4);
            }
        }
        winnerCheck();
    }

    public void button5() {
        if (varButton5 == 2) {
            if (turn == 0) {
                varButton5 = 0;
                viewForButton5.setImageResource(R.drawable.o);
                viewForButton5.animate().alpha(1).translationX(0).rotation(360);
                turn = 1;
                userTurnCount++;
                userTurn.add(5);
            } else {
                varButton5 = 1;
                viewForButton5.setImageResource(R.drawable.x);
                if (player == 1) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            viewForButton5.animate().alpha(1).translationX(0).rotation(360);
                        }
                    }, 500);
                } else {
                    viewForButton5.animate().alpha(1).translationX(0).rotation(360);
                }
                turn = 0;
            }
        }
        winnerCheck();
    }

    public void button6() {
        if (turn != 0) {
            turn = 0;
            if (phase == 2) {
                viewForButton2.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton2.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton2 = 1;
            } else if (phase == 3) {
                viewForButton4.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton4.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton4 = 1;
            } else if (phase == 4) {
                viewForButton8.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton8.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton8 = 1;
            } else {
                if (varButton6 == 2) {
                    viewForButton6.setImageResource(R.drawable.x);
                    if (player == 1) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                viewForButton6.animate().alpha(1).translationX(0).rotation(360);
                            }
                        }, 500);
                    } else {
                        viewForButton6.animate().alpha(1).translationX(0).rotation(360);
                    }
                    varButton6 = 1;
                } else {
                    turn = 1;
                }
            }
        } else if (varButton6 == 2) {
            varButton6 = 0;
            viewForButton6.setImageResource(R.drawable.o);
            viewForButton6.animate().alpha(1).translationX(0).rotation(360);
            turn = 1;
            userTurnCount++;
            if (phase == 2) {
                userTurn.add(8);
            } else if (phase == 3) {
                userTurn.add(4);
            } else if (phase == 4) {
                userTurn.add(2);
            } else {
                userTurn.add(6);
            }
        }
        winnerCheck();
    }

    public void button7() {
        if (turn != 0) {
            turn = 0;
            if (phase == 2) {
                viewForButton9.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton9.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton9 = 1;
            } else if (phase == 3) {
                viewForButton3.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton3.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton3 = 1;
            } else if (phase == 4) {
                viewForButton1.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton1.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton1 = 1;
            } else {
                if (varButton7 == 2) {
                    viewForButton7.setImageResource(R.drawable.x);
                    if (player == 1) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                viewForButton7.animate().alpha(1).translationX(0).rotation(360);
                            }
                        }, 500);
                    } else {
                        viewForButton7.animate().alpha(1).translationX(0).rotation(360);
                    }
                    varButton7 = 1;
                } else {
                    turn = 1;
                }
            }
        } else if (varButton7 == 2) {
            varButton7 = 0;
            viewForButton7.setImageResource(R.drawable.o);
            viewForButton7.animate().alpha(1).translationX(0).rotation(360);
            turn = 1;
            userTurnCount++;
            if (phase == 2) {
                userTurn.add(1);
            } else if (phase == 3) {
                userTurn.add(3);
            } else if (phase == 4) {
                userTurn.add(9);
            } else {
                userTurn.add(7);
            }
        }
        winnerCheck();
    }

    public void button8() {
        if (turn != 0) {
            turn = 0;
            if (phase == 2) {
                viewForButton6.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton6.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton6 = 1;
            } else if (phase == 3) {
                viewForButton2.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton2.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton2 = 1;
            } else if (phase == 4) {
                viewForButton4.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton4.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton4 = 1;
            } else {
                if (varButton8 == 2) {
                    viewForButton8.setImageResource(R.drawable.x);
                    if (player == 1) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                viewForButton8.animate().alpha(1).translationX(0).rotation(360);
                            }
                        }, 500);
                    } else {
                        viewForButton8.animate().alpha(1).translationX(0).rotation(360);
                    }
                    varButton8 = 1;
                } else {
                    turn = 1;
                }
            }
        } else if (varButton8 == 2) {
            varButton8 = 0;
            viewForButton8.setImageResource(R.drawable.o);
            viewForButton8.animate().alpha(1).translationX(0).rotation(360);
            turn = 1;
            userTurnCount++;
            if (phase == 2) {
                userTurn.add(4);
            } else if (phase == 3) {
                userTurn.add(2);
            } else if (phase == 4) {
                userTurn.add(6);
            } else {
                userTurn.add(8);
            }
        }
        winnerCheck();
    }

    public void button9() {
        if (turn != 0) {
            turn = 0;
            if (phase == 2) {
                viewForButton3.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton3.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton3 = 1;
            } else if (phase == 3) {
                viewForButton1.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton1.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton1 = 1;
            } else if (phase == 4) {
                viewForButton7.setImageResource(R.drawable.x);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewForButton7.animate().alpha(1).translationX(0).rotation(360);
                    }
                }, 500);
                varButton7 = 1;
            } else {
                if (varButton9 == 2) {
                    viewForButton9.setImageResource(R.drawable.x);
                    if (player == 1) {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                viewForButton9.animate().alpha(1).translationX(0).rotation(360);
                            }
                        }, 500);
                    } else {
                        viewForButton9.animate().alpha(1).translationX(0).rotation(360);
                    }
                    varButton9 = 1;
                } else {
                    turn = 1;
                }
            }
        } else if (varButton9 == 2) {
            varButton9 = 0;
            viewForButton9.setImageResource(R.drawable.o);
            viewForButton9.animate().alpha(1).translationX(0).rotation(360);
            turn = 1;
            userTurnCount++;
            if (phase == 2) {
                userTurn.add(7);
            } else if (phase == 3) {
                userTurn.add(1);
            } else if (phase == 4) {
                userTurn.add(3);
            } else {
                userTurn.add(9);
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
        TextView dialogTxt = (TextView) myDialog.findViewById(R.id.txt_declare);
        Button playAgain = (Button) myDialog.findViewById(R.id.button_again);
        Button exit = (Button) myDialog.findViewById(R.id.button_exit);
        if (player == 1) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    myDialog.show();
                }
            }, 1500);
        } else {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    myDialog.show();
                }
            }, 1000);
        }
        if (winner == 0) {
            dialogTxt.setText("O wins!");
            isGameRunning = false;
        } else if (winner == 1) {
            if (player == 2) {
                dialogTxt.setText("X wins!");
            } else {
                dialogTxt.setText("You lose!");
            }
            isGameRunning = false;
        } else {
            dialogTxt.setText("Match draw!");
            isGameRunning = false;
        }
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
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

    public void computerTurn() {
        if (userTurnCount == 1) {
            if (userTurn.get(0) != 5) {
                button5();
                if (userTurn.get(0) == 1 || userTurn.get(0) == 4) {
                    phase = 2;
                    return;
                } else if (userTurn.get(0) == 7 || userTurn.get(0) == 8) {
                    phase = 3;
                    return;
                } else if (userTurn.get(0) == 9 || userTurn.get(0) == 6) {
                    phase = 4;
                    return;
                } else {
                    return;
                }
            }
            button3();
        } else if (userTurnCount == 2) {
            if (userTurn.get(0) == 5) {
                if (userTurn.get(1) == 1) {
                    button9();
                } else if (userTurn.get(1) == 2) {
                    button8();
                } else if (userTurn.get(1) == 4) {
                    button6();
                } else if (userTurn.get(1) == 6) {
                    button4();
                } else if (userTurn.get(1) == 7) {
                    button1();
                } else if (userTurn.get(1) == 8) {
                    button2();
                } else if (userTurn.get(1) == 9) {
                    button1();
                }
            } else if (userTurn.get(0) == 1 ||
                    userTurn.get(0) == 3 ||
                    userTurn.get(0) == 7 ||
                    userTurn.get(0) == 9) {
                if (userTurn.get(1) == 1) {
                    button2();
                } else if (userTurn.get(1) == 2) {
                    button1();
                } else if (userTurn.get(1) == 4) {
                    button7();
                } else if (userTurn.get(1) == 6) {
                    button9();
                } else if (userTurn.get(1) == 7) {
                    button2();
                } else if (userTurn.get(1) == 8) {
                    button7();
                } else if (userTurn.get(1) == 9) {
                    button6();
                }
            } else if (userTurn.get(1) == 1) {
                button3();
            } else if (userTurn.get(1) == 3) {
                button1();
            } else if (userTurn.get(1) == 4) {
                button1();
            } else if (userTurn.get(1) == 6) {
                button3();
            } else if (userTurn.get(1) == 7) {
                button4();
            } else if (userTurn.get(1) == 8) {
                button4();
            } else if (userTurn.get(1) == 9) {
                button1();
            }
        } else if (userTurnCount == 3) {
            if (userTurn.get(0) == 5) {
                if (userTurn.get(1) == 1) {
                    if (userTurn.get(2) == 6) {
                        button4();
                    } else {
                        button6();
                    }
                } else if (userTurn.get(1) == 2) {
                    if (userTurn.get(2) == 1) {
                        button9();
                    } else if (userTurn.get(2) == 4) {
                        button6();
                    } else if (userTurn.get(2) == 6) {
                        button4();
                    } else if (userTurn.get(2) == 7) {
                        button6();
                    } else if (userTurn.get(2) == 9) {
                        button1();
                    }
                } else if (userTurn.get(1) == 4) {
                    if (userTurn.get(2) == 9) {
                        button1();
                    } else {
                        button9();
                    }
                } else if (userTurn.get(1) == 6) {
                    if (userTurn.get(2) == 1) {
                        button9();
                    } else if (userTurn.get(2) == 2) {
                        button8();
                    } else if (userTurn.get(2) == 7) {
                        button1();
                    } else if (userTurn.get(2) == 8) {
                        button2();
                    } else if (userTurn.get(2) == 9) {
                        button1();
                    }
                } else if (userTurn.get(1) == 7) {
                    if (userTurn.get(2) == 2) {
                        button8();
                    } else {
                        button2();
                    }
                } else if (userTurn.get(1) == 8) {
                    if (userTurn.get(2) == 1) {
                        button9();
                    } else {
                        button1();
                    }
                } else if (userTurn.get(1) != 9) {
                } else {
                    if (userTurn.get(2) == 2) {
                        button8();
                    } else {
                        button2();
                    }
                }
            } else if (userTurn.get(0) == 1 || userTurn.get(0) == 3 || userTurn.get(0) == 7 || userTurn.get(0) == 9) {
                if (userTurn.get(1) == 1) {
                    if (userTurn.get(2) == 8) {
                        button6();
                    } else {
                        button8();
                    }
                } else if (userTurn.get(1) == 2) {
                    if (userTurn.get(2) == 9) {
                        button6();
                    } else {
                        button9();
                    }
                } else if (userTurn.get(1) == 4) {
                    if (userTurn.get(2) == 1) {
                        button2();
                    } else if (userTurn.get(2) == 2) {
                        button1();
                    } else if (userTurn.get(2) == 6) {
                        button9();
                    } else if (userTurn.get(2) == 8) {
                        button9();
                    } else if (userTurn.get(2) == 9) {
                        button6();
                    }
                } else if (userTurn.get(1) == 6) {
                    if (userTurn.get(2) == 1) {
                        button2();
                    } else {
                        button1();
                    }
                } else if (userTurn.get(1) == 7) {
                    if (userTurn.get(2) == 8) {
                        button9();
                    } else {
                        button8();
                    }
                } else if (userTurn.get(1) == 8) {
                    if (userTurn.get(2) == 1) {
                        button2();
                    } else if (userTurn.get(2) == 2) {
                        button1();
                    } else if (userTurn.get(2) == 4) {
                        button1();
                    } else if (userTurn.get(2) == 6) {
                        button9();
                    } else if (userTurn.get(2) == 9) {
                        button6();
                    }
                } else if (userTurn.get(1) != 9) {
                } else {
                    if (userTurn.get(2) == 4) {
                        button8();
                    } else {
                        button4();
                    }
                }
            } else if (userTurn.get(0) != 2 && userTurn.get(0) != 4 && userTurn.get(0) != 6 && userTurn.get(0) != 8) {
            } else {
                if (userTurn.get(1) == 1) {
                    if (userTurn.get(2) == 7) {
                        button4();
                    } else {
                        button7();
                    }
                } else if (userTurn.get(1) == 3) {
                    if (userTurn.get(2) == 9) {
                        button6();
                    } else {
                        button9();
                    }
                } else if (userTurn.get(1) == 4) {
                    if (userTurn.get(2) == 9) {
                        button7();
                    } else {
                        button9();
                    }
                } else if (userTurn.get(1) == 6) {
                    if (userTurn.get(2) == 7) {
                        button9();
                    } else {
                        button7();
                    }
                } else if (userTurn.get(1) == 7) {
                    if (userTurn.get(2) == 6) {
                        button9();
                    } else {
                        button6();
                    }
                } else if (userTurn.get(1) == 8) {
                    if (userTurn.get(2) == 6) {
                        button1();
                    } else {
                        button6();
                    }
                } else if (userTurn.get(1) != 9) {
                } else {
                    if (userTurn.get(2) == 3) {
                        button6();
                    } else if (userTurn.get(2) == 4) {
                        button7();
                    } else if (userTurn.get(2) == 6) {
                        button3();
                    } else if (userTurn.get(2) == 7) {
                        button8();
                    } else if (userTurn.get(2) == 8) {
                        button7();
                    }
                }
            }
        } else if (userTurnCount != 4) {
        } else {
            if (userTurn.get(0) == 5) {
                if (userTurn.get(1) == 1) {
                    if (userTurn.get(2) != 6) {
                        return;
                    }
                    if (userTurn.get(3) == 2) {
                        button8();
                    } else if (userTurn.get(3) == 7) {
                        button2();
                    } else if (userTurn.get(3) == 8) {
                        button2();
                    }
                } else if (userTurn.get(1) == 2) {
                    if (userTurn.get(2) == 1) {
                        if (userTurn.get(3) == 7) {
                            button6();
                        } else {
                            button7();
                        }
                    } else if (userTurn.get(2) == 4) {
                        if (userTurn.get(3) == 9) {
                            button1();
                        } else {
                            button9();
                        }
                    } else if (userTurn.get(2) == 6) {
                        if (userTurn.get(3) == 1) {
                            button9();
                        } else if (userTurn.get(3) == 7) {
                            button1();
                        } else if (userTurn.get(3) == 9) {
                            button1();
                        }
                    } else if (userTurn.get(2) == 7) {
                        if (userTurn.get(3) == 9) {
                            button1();
                        } else {
                            button9();
                        }
                    } else if (userTurn.get(2) != 9) {
                    } else {
                        if (userTurn.get(3) == 4) {
                            button6();
                        } else if (userTurn.get(3) == 6) {
                            button4();
                        } else if (userTurn.get(3) == 7) {
                            button4();
                        }
                    }
                } else if (userTurn.get(1) == 4) {
                    if (userTurn.get(2) != 9) {
                        return;
                    }
                    if (userTurn.get(3) == 2) {
                        button8();
                    } else {
                        button2();
                    }
                } else if (userTurn.get(1) == 6) {
                    if (userTurn.get(2) == 1) {
                        if (userTurn.get(3) == 2) {
                            button8();
                        } else if (userTurn.get(3) == 7) {
                            button2();
                        } else if (userTurn.get(3) == 8) {
                            button2();
                        }
                    } else if (userTurn.get(2) == 2) {
                        if (userTurn.get(3) == 1) {
                            button9();
                        } else if (userTurn.get(3) == 7) {
                            button1();
                        } else if (userTurn.get(3) == 9) {
                            button1();
                        }
                    } else if (userTurn.get(2) == 7) {
                        if (userTurn.get(3) == 2) {
                            button8();
                        } else {
                            button2();
                        }
                    } else if (userTurn.get(2) == 8) {
                        if (userTurn.get(3) == 1) {
                            button9();
                        } else {
                            button1();
                        }
                    } else if (userTurn.get(2) != 9) {
                    } else {
                        if (userTurn.get(3) == 2) {
                            button7();
                        } else {
                            button2();
                        }
                    }
                } else if (userTurn.get(1) == 7) {
                    if (userTurn.get(2) != 2) {
                        return;
                    }
                    if (userTurn.get(3) == 4) {
                        button6();
                    } else if (userTurn.get(3) == 6) {
                        button4();
                    } else if (userTurn.get(3) == 9) {
                        button4();
                    }
                } else if (userTurn.get(1) == 8) {
                    if (userTurn.get(2) != 1) {
                        return;
                    }
                    if (userTurn.get(3) == 6) {
                        button4();
                    } else {
                        button6();
                    }
                } else if (userTurn.get(1) != 9 || userTurn.get(2) != 2) {
                } else {
                    if (userTurn.get(3) == 4) {
                        button6();
                    } else if (userTurn.get(3) == 6) {
                        button4();
                    } else if (userTurn.get(3) == 7) {
                        button4();
                    }
                }
            } else if (userTurn.get(0) == 1 || userTurn.get(0) == 3 || userTurn.get(0) == 7 || userTurn.get(0) == 9) {
                if (userTurn.get(1) == 1) {
                    if (userTurn.get(2) != 8) {
                        return;
                    }
                    if (userTurn.get(3) == 4) {
                        button7();
                    } else {
                        button4();
                    }
                } else if (userTurn.get(1) == 2) {
                    if (userTurn.get(2) != 9) {
                        return;
                    }
                    if (userTurn.get(3) == 4) {
                        button7();
                    } else {
                        button4();
                    }
                } else if (userTurn.get(1) == 4) {
                    if (userTurn.get(2) == 1) {
                        if (userTurn.get(3) == 8) {
                            button6();
                        } else {
                            button8();
                        }
                    } else if (userTurn.get(2) == 2) {
                        if (userTurn.get(3) == 9) {
                            button6();
                        } else {
                            button9();
                        }
                    } else if (userTurn.get(2) == 6) {
                        if (userTurn.get(3) == 1) {
                            button8();
                        } else {
                            button1();
                        }
                    } else if (userTurn.get(2) == 8) {
                        if (userTurn.get(3) == 1) {
                            button2();
                        } else {
                            button1();
                        }
                    } else if (userTurn.get(2) != 9) {
                    } else {
                        if (userTurn.get(3) == 1) {
                            button2();
                        } else if (userTurn.get(3) == 2) {
                            button1();
                        } else if (userTurn.get(3) == 8) {
                            button1();
                        }
                    }
                } else if (userTurn.get(1) == 6) {
                    if (userTurn.get(2) != 1) {
                        return;
                    }
                    if (userTurn.get(3) == 8) {
                        button4();
                    } else {
                        button8();
                    }
                } else if (userTurn.get(1) == 7) {
                    if (userTurn.get(2) != 8) {
                        return;
                    }
                    if (userTurn.get(3) == 1) {
                        button4();
                    } else {
                        button1();
                    }
                } else if (userTurn.get(1) == 8) {
                    if (userTurn.get(2) == 1) {
                        if (userTurn.get(3) == 4) {
                            button6();
                        } else if (userTurn.get(3) == 6) {
                            button9();
                        } else if (userTurn.get(9) == 9) {
                            button6();
                        }
                    } else if (userTurn.get(2) == 2) {
                        if (userTurn.get(3) == 4) {
                            button9();
                        } else {
                            button4();
                        }
                    } else if (userTurn.get(2) == 4) {
                        if (userTurn.get(3) == 9) {
                            button6();
                        } else {
                            button9();
                        }
                    } else if (userTurn.get(2) == 6) {
                        if (userTurn.get(3) == 1) {
                            button2();
                        } else {
                            button1();
                        }
                    } else if (userTurn.get(2) != 9) {
                    } else {
                        if (userTurn.get(3) == 4) {
                            button1();
                        } else {
                            button4();
                        }
                    }
                } else if (userTurn.get(1) != 9 || userTurn.get(2) != 4) {
                } else {
                    if (userTurn.get(3) == 2) {
                        button1();
                    } else {
                        button2();
                    }
                }
            } else if (userTurn.get(0) != 2 && userTurn.get(0) != 4 && userTurn.get(0) != 6 && userTurn.get(0) != 8) {
            } else {
                if (userTurn.get(1) == 1) {
                    if (userTurn.get(2) != 7) {
                        return;
                    }
                    if (userTurn.get(3) == 6) {
                        button8();
                    } else {
                        button6();
                    }
                } else if (userTurn.get(1) == 3) {
                    if (userTurn.get(2) != 9) {
                        return;
                    }
                    if (userTurn.get(3) == 4) {
                        button7();
                    } else {
                        button4();
                    }
                } else if (userTurn.get(1) == 4) {
                    if (userTurn.get(2) != 9) {
                        return;
                    }
                    if (userTurn.get(3) == 3) {
                        button6();
                    } else {
                        button3();
                    }
                } else if (userTurn.get(1) == 6) {
                    if (userTurn.get(2) != 7) {
                        return;
                    }
                    if (userTurn.get(3) == 1) {
                        button4();
                    } else {
                        button1();
                    }
                } else if (userTurn.get(1) == 7) {
                    if (userTurn.get(2) != 6) {
                        return;
                    }
                    if (userTurn.get(3) == 1) {
                        button3();
                    } else {
                        button1();
                    }
                } else if (userTurn.get(1) == 8) {
                    if (userTurn.get(2) != 6) {
                        return;
                    }
                    if (userTurn.get(3) == 9) {
                        button7();
                    } else {
                        button9();
                    }
                } else if (userTurn.get(1) != 9) {
                } else {
                    if (userTurn.get(2) == 3) {
                        if (userTurn.get(3) == 4) {
                            button7();
                        } else {
                            button4();
                        }
                    } else if (userTurn.get(2) == 4) {
                        if (userTurn.get(3) == 3) {
                            button6();
                        } else {
                            button3();
                        }
                    } else if (userTurn.get(2) == 6) {
                        if (userTurn.get(3) == 7) {
                            button8();
                        } else {
                            button7();
                        }
                    } else if (userTurn.get(2) == 7) {
                        if (userTurn.get(3) == 3) {
                            button6();
                        } else if (userTurn.get(3) == 4) {
                            button3();
                        } else if (userTurn.get(3) == 6) {
                            button3();
                        }
                    } else if (userTurn.get(2) != 8) {
                    } else {
                        if (userTurn.get(3) == 3) {
                            button4();
                        } else {
                            button3();
                        }
                    }
                }
            }
        }
    }

    private void toggleActionBar() {
        if (turn == 0) {
            head.setText("O's Turn");
        } else {
            head.setText("X's Turn");
        }
    }
}
