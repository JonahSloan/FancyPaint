package designer.components;

import java.awt.Color;
import javax.swing.JPanel;
import designer.Colors;
import designer.components.screen.EditorScreen;
import designer.components.screen.ScaleablePixelBox;

@SuppressWarnings("serial")
public class Palette extends JPanel
{
	private volatile Color currentcolor;
	public Palette(EditorScreen parent)
	{
		setSelectedColor(Color.WHITE);
		for(Colors color : Colors.values())
		{
			ScaleablePixelBox newbox = new ScaleablePixelBox(new Thread(new Runnable(){
				public void run(){
					setSelectedColor(color.getColor());
				}
			}), color.getColor(), parent, true);
			newbox.setToolTipText(color.toString());
			this.add(newbox);
		}
	}
	public Color getSelectedColor() {
		return this.currentcolor;
	}
	public void setSelectedColor(Color selectedcolor)
	{
		this.currentcolor = selectedcolor;
	}
}
