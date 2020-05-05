import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GUI extends JFrame {
	private JMenuBar menuBar;
	private JPanel first;
	private JPanel second;
	private JPanel third;
	private List<Player> players = new ArrayList<Player>();
	private JLabel dryer;

	public GUI() {
		super("DishCalc");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		/*
		 * Initialize JFrame
		 */
		Player f = new Player("Player 1");
		Player m = new Player("Player 2");
		Player c = new Player("Player 3");
		players.add(f);
		players.add(m);
		players.add(c);
		setBounds(100, 100, 1000, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setResizable(false);
		setMinimumSize(this.getSize());// get screen size as java Dimension
		// set preferred size as new height and width

		// panels

		first = new JPanel();
		dryer = new JLabel("Dryer");
		dryer.setFont(dryer.getFont().deriveFont(44.0f));
		dryer.setForeground(Color.white);
		first.add(dryer);
		first.setBackground(Color.orange);

		second = new JPanel();
		JLabel rinser = new JLabel("Washer");
		rinser.setFont(rinser.getFont().deriveFont(44.0f));
		rinser.setForeground(Color.white);
		second.add(rinser);
		second.setBackground(Color.orange);

		third = new JPanel();
		JLabel size = new JLabel("Size");
		size.setFont(size.getFont().deriveFont(44.0f));
		size.setForeground(Color.white);
		third.add(size);
		third.setBackground(Color.orange);

		add(first, BorderLayout.EAST);
		add(second, BorderLayout.WEST);
		add(third);

		// initialize menu bar

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// buttons

		JButton play = new JButton("Play");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				startGame(players);

			}
		});

		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				first.removeAll();
				second.removeAll();
				third.removeAll();
				for (int i = 0; i < players.size(); i++) {
					players.get(i).removeBuff();
				}
				dryer.setFont(dryer.getFont().deriveFont(44.0f));
				dryer.setForeground(Color.white);
				first.add(dryer);
				first.setBackground(Color.orange);

				JLabel rinser = new JLabel("Washer");
				rinser.setFont(rinser.getFont().deriveFont(44.0f));
				rinser.setForeground(Color.white);
				second.add(rinser);
				second.setBackground(Color.orange);

				JLabel size = new JLabel("Size");
				size.setFont(size.getFont().deriveFont(44.0f));
				size.setForeground(Color.white);
				third.add(size);
				third.setBackground(Color.orange);

				add(first, BorderLayout.EAST);
				add(second, BorderLayout.WEST);
				add(third);
				revalidate();

			}
		});

		JButton doubleOrNothing = new JButton("Double or Nothing");
		doubleOrNothing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String roll;
				Random ran = new Random();
				double randomValue = 0.0 + (1.0 - 0.0) * ran.nextDouble();

				if ((randomValue <= 0.50) && (randomValue >= 0.00)) {
					roll = "DOUBLE";
				} else {
					roll = "NOTHING";
				}

				displayMessage(roll);
			}
		});

		menuBar.add(play);
		menuBar.add(reset);
		menuBar.add(doubleOrNothing);
		setVisible(true);

	}

	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	private void startGame(List<Player> p) {
		int dryer = getRandomNumberInRange(0, 3);
		int rinser = getRandomNumberInRange(0, 3);

		Random ran = new Random(); // (probability)
		double randomValue = 0.0 + (1.0 - 0.0) * ran.nextDouble();

		for (int e = 0; e < p.size(); e++) {
			if (e == dryer) {
				p.get(e).setDryer();
			}
		}
		for (int r = 0; r < p.size(); r++) {
			if (r == rinser) {
				p.get(r).setRinser();
			}
		}

		for (int i = 0; i < p.size(); i++) {
			if (p.get(i).isDryer()) {
				if (p.get(i).getName().equals("Player 3")) {

					JLabel player = new JLabel("   Player 3");
					player.setFont(player.getFont().deriveFont(44.0f));
					player.setForeground(Color.red);
					first.add(player);
					revalidate();

				}

				if (p.get(i).getName().equals("Player 2")) {

					JLabel player = new JLabel("   Player 2");
					player.setFont(player.getFont().deriveFont(44.0f));
					player.setForeground(Color.red);
					first.add(player);
					revalidate();

				}

				if (p.get(i).getName().equals("Player 1")) {

					JLabel player = new JLabel("   Player 1");
					player.setFont(player.getFont().deriveFont(44.0f));
					player.setForeground(Color.red);
					first.add(player);
					revalidate();

				}

			}

			if (p.get(i).isRinser()) {

				if (p.get(i).getName().equals("Player 3")) {

					JLabel player = new JLabel("   Player 3");
					player.setFont(player.getFont().deriveFont(44.0f));
					player.setForeground(Color.red);
					second.add(player);
					revalidate();

				}

				if (p.get(i).getName().equals("Player 2")) {
					JLabel player = new JLabel("   Player 2");
					player.setFont(player.getFont().deriveFont(44.0f));
					player.setForeground(Color.red);
					second.add(player);
					revalidate();
				}

				if (p.get(i).getName().equals("Player 1")) {

					JLabel player = new JLabel("   Player 1");
					player.setFont(player.getFont().deriveFont(44.0f));
					player.setForeground(Color.red);
					second.add(player);
					revalidate();

				}

			}

		}

		if ((randomValue <= 0.50) && (randomValue >= 0.00)) {
			JLabel player = new JLabel("   All");
			player.setFont(player.getFont().deriveFont(44.0f));
			player.setForeground(Color.blue);
			third.add(player);
			revalidate();
		} else {
			JLabel player = new JLabel("   Half");
			player.setFont(player.getFont().deriveFont(44.0f));
			player.setForeground(Color.blue);
			third.add(player);
			revalidate();
		}

	}

}
