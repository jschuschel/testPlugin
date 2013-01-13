package com.slipvyne.testPlugin;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MyPluginExec implements CommandExecutor {
 
	private testPlugin plugin; // pointer to your main class, unrequired if you don't need methods from the main class
 
	public MyPluginExec(testPlugin plugin) {
		this.plugin = plugin;
	}
 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("cubeMake")){ // If the player typed /basic then do the following...
			Player target = sender.getServer().getPlayer(sender.getName());
			generateCube(target.getLocation(), 5);
			return true;
		} //If this has happened the function will return true. 
	        // If this hasn't happened the a value of false will be returned.
		return false; 
	}
	
	
	public void generateCube(Location loc, int length){  // public visible method generateCube() with 2 parameters point and location
		World world = loc.getWorld();
	 
		int x_start = loc.getBlockX();     // Set the startpoints to the coordinates of the given location
		int y_start = loc.getBlockY();
		int z_start = loc.getBlockZ();
	        /* Note: used getBlockX() instead of getX() because it returns an int value and avoid the cast with (int)loc.getX() */
	 
		int x_length = x_start + length;    // now i set the lengths for each dimension... should be clear.
		int y_length = y_start + length;
		int z_length = z_start + length;
	 
		for(int x_operate = x_start; x_operate <= x_length; x_operate++){ 
			// Loop 1 for the X-Dimension "for x_operate (which is set to x_start) 
			//do whats inside the loop while x_operate is 
			//<= x_length and after each loop increase 
			//x_operate by 1 (x_operate++ is the same as x_operate=x_operate+1;)
			for(int y_operate = y_start; y_operate <= y_length; y_operate++){// Loop 2 for the Y-Dimension
				for(int z_operate = z_start; z_operate <= z_length; z_operate++){// Loop 3 for the Z-Dimension
	 
	                                // get the block with the current coordinates
					Block blockToChange = world.getBlockAt(x_operate,y_operate,z_operate);
					blockToChange.setTypeId(2);    // set the block to Type 34
				}
			}
		}
	}
}