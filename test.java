/*
Game that acts like Whack-a-Mole

@author: Chase Williams
@date: 06/23/17
*/

int row = 0; int col = 0;
int score = 0;
final color background_c = #1C0B19;
final color default_c = #2D3047;
color[][] squares = new color[5][5];
color[] colors = { #419D78, #E0A458, #FFDBB5, #C04ABC, #F6E27F, #E2C391, #43ACC6 };
int num_colors = colors.length;
int rand_row; int rand_col; int rand_color;
int counter = 0;
boolean got_it = false;

void setup() {
  surface.setSize(500, 600);
  background(background_c);
  stroke(#140D4F);
  
  for (int i = 0; i < 5; i ++) {
    for (int j = 0; j < 5; j ++) {
      squares[i][j] = default_c;
    }
  }
  
  rand_row = int(random(5));
  rand_col = int(random(5));
  rand_color = int(random(num_colors));
  
  generate_grid();
}

void draw() {
  if (counter >= 40 || got_it) {
    generate_grid();
    counter = 0;
    got_it = false;
  }
  
  textSize(32);
  fill(#FB5607);
  text("Score: " + score, 190, 550);
  counter += 1;
}

void generate_grid() {
  background(background_c);
  
  squares[rand_row][rand_col] = default_c;
  
  rand_row = int(random(5));
  rand_col = int(random(5));
  rand_color = int(random(num_colors));
  
  squares[rand_row][rand_col] = colors[rand_color]; 
  int y = 0; int x = 0;
  for (int i = 0; i < 5; i ++) {
    x = 0;
    for (int j = 0; j < 5; j ++) {
      color color_ = squares[i][j];
      fill(color_);
      rect(x, y, 100, 100);
      x += 100;
    }
    y += 100;
  }
}

void mousePressed() {
  int row = int(mouseX / 100);
  int col = int(mouseY / 100);
  
  if (squares[col][row] != default_c) {
    score += 1;
    got_it = true;
  }
}
