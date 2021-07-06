package hanoi_tower;
import java.awt.Color;
import java.awt.Graphics;
public class rod
{
	public static void draw(Graphics g)
	{
		//Rod's horizontal base
		g.setColor(new Color(204,102,0));
		g.fillRoundRect(50, 350, 200, 10, 10, 10);  //A
		g.fillRoundRect(300, 350, 200, 10, 10, 10); //B
		g.fillRoundRect(550, 350, 200, 10, 10, 10); //C
		//Rod's vertical base
		g.fillRoundRect(145, 110, 10, 250, 10, 10);
		g.fillRoundRect(395, 110, 10, 250, 10, 10);
		g.fillRoundRect(645, 110, 10, 250, 10, 10);
	}
}