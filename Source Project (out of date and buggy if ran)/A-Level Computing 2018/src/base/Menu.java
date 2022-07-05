// 
// Decompiled by Procyon v0.5.36
// 

package base;

import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.image.ImageObserver;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Image;

public class Menu
{
    public int state;
    public int buttonHovered;
    public int diffHovered;
    public int levelCount;
    private boolean imagesLoaded;
    private int buttonWidth;
    private int buttonHeight;
    private Image stage1;
    private BufferedImage Bstage1;
    private Image stage2;
    private BufferedImage Bstage2;
    private Image stage3;
    private BufferedImage Bstage3;
    private Image HowToPlay;
    Rectangle[] buttons;
    Rectangle easy;
    Rectangle medium;
    Rectangle hard;
    
    public Menu() {
        this.state = 0;
        this.buttonHovered = -1;
        this.diffHovered = -1;
        this.levelCount = 3;
        this.imagesLoaded = false;
        this.buttonWidth = 140;
        this.buttonHeight = 50;
        this.buttons = new Rectangle[] { new Rectangle(90, 375, this.buttonWidth, this.buttonHeight), new Rectangle(280, 375, this.buttonWidth, this.buttonHeight), new Rectangle(470, 375, this.buttonWidth, this.buttonHeight), new Rectangle(30, 620, this.buttonWidth, this.buttonHeight), new Rectangle(493, 14, this.buttonWidth, this.buttonHeight) };
        this.easy = new Rectangle(-500, -500, this.buttonWidth, this.buttonHeight);
        this.medium = new Rectangle(-500, -500, this.buttonWidth, this.buttonHeight);
        this.hard = new Rectangle(-500, -500, this.buttonWidth, this.buttonHeight);
    }
    
    public void display(final Graphics g) {
        if (!this.imagesLoaded) {
            try {
                this.Bstage1 = ImageIO.read(new File("./assets/images/stage1.png"));
                this.Bstage2 = ImageIO.read(new File("./assets/images/stage2.png"));
                this.Bstage3 = ImageIO.read(new File("./assets/images/stage3.png"));
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            this.stage1 = ImageEditor.scale(this.Bstage1, this.buttonWidth, this.buttonWidth);
            this.stage2 = ImageEditor.scale(this.Bstage2, this.buttonWidth, this.buttonWidth);
            this.stage3 = ImageEditor.scale(this.Bstage3, this.buttonWidth, this.buttonWidth);
            this.HowToPlay = new ImageIcon("./assets/images/howtoplay3.png").getImage();
            this.imagesLoaded = true;
        }
        for (int i = 0; i < this.buttons.length; ++i) {
            if (this.state == 0) {
                if (i < this.levelCount) {
                    if (i == this.buttonHovered) {
                        this.drawButton(this.buttons[i], Color.LIGHT_GRAY, "Stage " + (i + 1), g);
                    }
                    else {
                        this.drawButton(this.buttons[i], Color.GRAY, "Stage " + (i + 1), g);
                    }
                }
                if (i == 3) {
                    if (i == this.buttonHovered) {
                        this.drawButton(this.buttons[i], Color.LIGHT_GRAY, "How to play", g);
                    }
                    else {
                        this.drawButton(this.buttons[i], Color.GRAY, "How to play", g);
                    }
                }
                if (this.buttonHovered >= 0 && this.buttonHovered < this.levelCount) {
                    this.easy.x = this.buttons[this.buttonHovered].x;
                    this.easy.y = this.buttons[this.buttonHovered].y + this.buttonHeight * 1;
                    this.medium.x = this.buttons[this.buttonHovered].x;
                    this.medium.y = this.buttons[this.buttonHovered].y + this.buttonHeight * 2;
                    this.hard.x = this.buttons[this.buttonHovered].x;
                    this.hard.y = this.buttons[this.buttonHovered].y + this.buttonHeight * 3;
                    if (this.diffHovered == 0) {
                        this.drawButton(this.easy, Color.LIGHT_GRAY, "Easy", g);
                    }
                    else {
                        this.drawButton(this.easy, Color.GRAY, "Easy", g);
                    }
                    if (this.diffHovered == 1) {
                        this.drawButton(this.medium, Color.LIGHT_GRAY, "Medium", g);
                    }
                    else {
                        this.drawButton(this.medium, Color.gray, "Medium", g);
                    }
                    if (this.diffHovered == 2) {
                        this.drawButton(this.hard, Color.LIGHT_GRAY, "Hard", g);
                    }
                    else {
                        this.drawButton(this.hard, Color.gray, "Hard", g);
                    }
                }
                else {
                    final Rectangle easy = this.easy;
                    final Rectangle easy2 = this.easy;
                    final int n = -500;
                    easy2.y = n;
                    easy.x = n;
                    final Rectangle medium = this.medium;
                    final Rectangle medium2 = this.medium;
                    final int n2 = -500;
                    medium2.y = n2;
                    medium.x = n2;
                    final Rectangle hard = this.hard;
                    final Rectangle hard2 = this.hard;
                    final int n3 = -500;
                    hard2.y = n3;
                    hard.x = n3;
                }
                g.drawImage(this.stage1, this.buttons[0].x, this.buttons[0].y - this.buttonWidth - 10, null);
                g.drawImage(this.stage2, this.buttons[1].x, this.buttons[1].y - this.buttonWidth - 10, null);
                g.drawImage(this.stage3, this.buttons[2].x, this.buttons[2].y - this.buttonWidth - 10, null);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Consolas", 1, 50));
                g.setColor(Color.RED);
                g.drawString("J", 210, 80);
                g.setColor(Color.ORANGE);
                g.drawString("a", 235, 80);
                g.setColor(Color.YELLOW);
                g.drawString("k", 260, 80);
                g.setColor(Color.GREEN);
                g.drawString("e", 285, 80);
                g.setColor(new Color(101, 101, 255));
                g.drawString("'", 310, 80);
                g.setColor(new Color(0, 0, 230));
                g.drawString("s", 335, 80);
                g.setColor(Color.RED);
                g.drawString(" ", 360, 80);
                g.setColor(new Color(138, 43, 226));
                g.drawString("G", 385, 80);
                g.setColor(new Color(186, 85, 211));
                g.drawString("a", 410, 80);
                g.setColor(Color.RED);
                g.drawString("m", 435, 80);
                g.setColor(Color.ORANGE);
                g.drawString("e", 460, 80);
            }
            if (this.state == 1) {
                if (i == this.buttonHovered) {
                    this.drawButton(this.buttons[4], Color.LIGHT_GRAY, "Back", g);
                }
                else {
                    this.drawButton(this.buttons[4], Color.GRAY, "Back", g);
                }
                g.drawImage(this.HowToPlay, 0, 0, null);
            }
        }
    }
    
    private void drawButton(final Rectangle r, final Color c, final String input, final Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(r.x, r.y, r.width, r.height);
        g.setColor(c);
        g.fillRect(r.x + 2, r.y + 2, r.width - 4, r.height - 4);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Consolas", 1, 20));
        g.drawString(input, r.x + r.width / 2 - (int)(input.length() * 5.6), r.y + r.height / 2 + 6);
    }
    
    public void mouseMoved(final MouseEvent e) {
        final int mx = e.getX();
        final int my = e.getY();
        if (this.buttonHovered == -1) {
            for (int i = 0; i < this.buttons.length; ++i) {
                if (mx >= this.buttons[i].x && mx <= this.buttons[i].x + this.buttons[i].width && my >= this.buttons[i].y && my <= this.buttons[i].y + this.buttons[i].height) {
                    this.buttonHovered = i;
                }
            }
        }
        else if (mx < this.buttons[this.buttonHovered].x || mx > this.buttons[this.buttonHovered].x + this.buttons[this.buttonHovered].width || my < this.buttons[this.buttonHovered].y || my > this.buttons[this.buttonHovered].y + this.buttons[this.buttonHovered].height * 4) {
            this.buttonHovered = -1;
        }
        if (mx >= this.easy.x && mx <= this.easy.x + this.easy.width && my >= this.easy.y && my <= this.easy.y + this.easy.height) {
            this.diffHovered = 0;
        }
        else if (mx >= this.medium.x && mx <= this.medium.x + this.medium.width && my >= this.medium.y && my <= this.medium.y + this.medium.height) {
            this.diffHovered = 1;
        }
        else if (mx >= this.hard.x && mx <= this.hard.x + this.hard.width && my >= this.hard.y && my <= this.hard.y + this.hard.height) {
            this.diffHovered = 2;
        }
        else {
            this.diffHovered = -1;
        }
    }
    
    public void mouseClicked(final MouseEvent e) {
        if (this.state == 0 && this.buttonHovered == 3) {
            this.state = 1;
        }
        if (this.state == 1 && this.buttonHovered == 4) {
            this.state = 0;
        }
    }
    
    private void log(final String s) {
        System.out.println(s);
    }
}
