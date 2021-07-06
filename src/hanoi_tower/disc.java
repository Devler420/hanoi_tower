package hanoi_tower;

import java.awt.Color;
import java.awt.Graphics;

public class disc
{
	public int R, G, B, aSize, W, H;
	public int discHeight[];
	public Vector pos, vel, acc;
	public boolean isMoving = false;

	public disc(int discHeight[])
	{
		this.discHeight = discHeight;
	}

	public void moveto(int rodStart, int rodDest)
	{
		isMoving = true;
		vel = new Vector();
		vel.x = (rodDest - rodStart) * 10;
		vel.y = -12;

		pos = pos.add(vel);

		//System.out.println("rodDest" + rodDest + " " + pos.x);

		if (rodDest == 0 && pos.x > 25 && pos.x < 100)
		{
			pos.x = 145 - W/2;
			pos.y = -discHeight[rodDest] * 20 + 335;
			vel.x = 0;
			vel.y = 0;
			acc.x = 0;
			acc.y = 0;
			isMoving = false;
		}

		if (rodDest == 1 && pos.x > 300 && pos.x < 400)
		{
			pos.x = 395 - W/2;
			pos.y = -discHeight[rodDest] * 20 + 335;
			vel.x = 0;
			vel.y = 0;
			acc.x = 0;
			acc.y = 0;

			isMoving = false;
		}

		if (rodDest == 2 && pos.x > 500 && pos.x < 590)
		{
			pos.x = 645 - W/2;
			pos.y = -discHeight[rodDest] * 20 + 335;
			vel.x = 0;
			vel.y = 0;
			acc.x = 0;
			acc.y = 0;

			isMoving = false;
		}

	}

	public void draw(Graphics g)
	{
		g.setColor(new Color(R, G, B));
		g.fillRoundRect((int) pos.x, (int) pos.y, W, H, aSize, aSize);

		// Rod A position
//		g.fillRoundRect(60, 335, 180, 15, 10, 10);
//		g.fillRoundRect(70, 320, 160, 15, 10, 10);
//		g.fillRoundRect(80, 305, 140, 15, 10, 10);
//		g.fillRoundRect(90, 290, 120, 15, 10, 10);
//		g.fillRoundRect(100, 275, 100, 15, 10, 10);
//		g.fillRoundRect(110, 260, 80, 15, 10, 10);
//		g.fillRoundRect(120, 245, 60, 15, 10, 10);
//		g.fillRoundRect(130, 230, 40, 15, 10, 10);

		// Rod B position
//		g.fillRoundRect(310, 335, 180, 15, 10, 10);
//		g.fillRoundRect(320, 320, 160, 15, 10, 10);
//		g.fillRoundRect(330, 305, 140, 15, 10, 10);
//		g.fillRoundRect(340, 290, 120, 15, 10, 10);
//		g.fillRoundRect(350, 275, 100, 15, 10, 10);
//		g.fillRoundRect(360, 260, 80, 15, 10, 10);
//		g.fillRoundRect(370, 245, 60, 15, 10, 10);
//		g.fillRoundRect(380, 230, 40, 15, 10, 10);

		// Rod C position
//		g.fillRoundRect(560, 335, 180, 15, 10, 10);
//		g.fillRoundRect(570, 320, 160, 15, 10, 10);
//		g.fillRoundRect(580, 305, 140, 15, 10, 10);
//		g.fillRoundRect(590, 290, 120, 15, 10, 10);
//		g.fillRoundRect(600, 275, 100, 15, 10, 10);
//		g.fillRoundRect(610, 260, 80, 15, 10, 10);
//		g.fillRoundRect(620, 245, 60, 15, 10, 10);
//		g.fillRoundRect(630, 230, 40, 15, 10, 10);

		// Border
		g.setColor(Color.black);
		g.drawRoundRect((int) pos.x, (int) pos.y, W, H, aSize, aSize);
//		g.drawRoundRect(60, 335, 180, 15, 10, 10);
	}

	public String toString()
	{
		return "Disc : " + W;
		
	}

}
