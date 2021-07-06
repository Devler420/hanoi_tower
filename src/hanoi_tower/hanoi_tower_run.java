package hanoi_tower;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class hanoi_tower_run extends JPanel
{
	disc[][] discs;
	int[] discHeight;
	ArrayList<StepMove> StepMoveLog;

	int Step = 0;

	public hanoi_tower_run()
	{
		StepMoveLog = new ArrayList<StepMove>();
		// starting q'ty of discs
		int n = 4;

		// Generate discs
		int iniposxRod0 = 60; 
		int iniposyRod0 = 335; 
		int iniWRod0 = 180; 
		discs = new disc[3][n];
		discHeight = new int[n+2];
		discHeight[0] = n;

		for (int i = 0; i < n; i++)
		{
			discs[0][i] = new disc(discHeight); // new Object
			discs[0][i].R = (int) (Math.random() * 255);
			discs[0][i].G = (int) (Math.random() * 255);
			discs[0][i].B = (int) (Math.random() * 255);
			discs[0][i].aSize = 10;

			discs[0][i].pos = new Vector();
			discs[0][i].pos.x = iniposxRod0;
			iniposxRod0 += 10;
			discs[0][i].pos.y = iniposyRod0;
			iniposyRod0 -= 15;
			discs[0][i].W = iniWRod0;
			iniWRod0 -= 20;

			discs[0][i].H = 15;

			discs[0][i].vel = new Vector();
			discs[0][i].vel.x = 1;
			discs[0][i].vel.y = -1;

			discs[0][i].acc = new Vector();
			discs[0][i].acc.x = 0.1;
			discs[0][i].acc.y = -0.1;
		}

		Thread t = new Thread(new Runnable() // moving disc
		{
			public void run()
			{
				while (true)
				{
					try
					{
						Thread.sleep(40);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}

					if (Step < StepMoveLog.size())
					{
						if (movedisc(StepMoveLog.get(Step).start, StepMoveLog.get(Step).dest))
						{
							Step++;

						}
					}

					repaint();
				}
			}
		});

		JFrame f = new JFrame();
		f.add(this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800, 500);
		f.setVisible(true);
		//Solve
		solveHanoi(n, 0, 1, 2);
		System.out.println(Arrays.toString(StepMoveLog.toArray()));

		t.start();
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		rod.draw(g);
		for (int t = 0; t < 3; t++)
		{
			for (int i = 0; i < discs[0].length; i++)
			{
				if (discs[t][i] != null)
					discs[t][i].draw(g);
			}
		}
	}

	public boolean movedisc(int a, int b)
	{
		System.out.println(a + " " + b);
		System.out.println(Arrays.toString(discs[a]));
		//System.out.println("Disc Height"+ a + " = " + discHeight[a]);
		System.out.println(Arrays.toString(discs[b]));
		//System.out.println("Disc Height"+ b + " = " + discHeight[b]);

		discs[a][discHeight[a] - 1].moveto(a, b);

		if (discs[a][discHeight[a] - 1].isMoving == false)
		{

			discs[b][discHeight[b]] = discs[a][discHeight[a] - 1];
			discs[a][discHeight[a] - 1] = null;

			discHeight[a]--;
			discHeight[b]++;

			return true;
		}
		return false;
	}

	// SolveHanoi Algorithm
	public void solveHanoi(int n, int rod0, int rod1, int rod2)
	{
		if (n == 1)
		{
			System.out.println(rod0 + " --> " + rod2);
			this.StepMoveLog.add(new StepMove(rod0, rod2));
			return;
		}
		solveHanoi(n - 1, rod0, rod2, rod1);
		System.out.println(rod0 + " --> " + rod2);
		this.StepMoveLog.add(new StepMove(rod0, rod2));
		solveHanoi(n - 1, rod1, rod0, rod2);
	}

	public static void main(String[] args)
	{
		new hanoi_tower_run();
	}

}
