package Pokemon;
import java.util.Arrays;

public class Pokemon {
	int id;
	String name;
	String[] types;
	int total;
	int hp;
	int atk;
	int def;
	int sp_atk;
	int sp_def;
	int speed;
	public Pokemon(String line)
	{
		String[] data = line.split(",");
		this.id = Integer.parseInt(data[0]);
		this.name = data[1];
		this.types = Arrays.copyOfRange(data, 2, 4);
		this.total = Integer.parseInt(data[4]);
		this.hp = Integer.parseInt(data[5]);
		this.atk = Integer.parseInt(data[6]);
		this.def = Integer.parseInt(data[7]);
		this.sp_atk = Integer.parseInt(data[8]);
		this.sp_def = Integer.parseInt(data[9]);
		this.speed = Integer.parseInt(data[10]);
	}
	public Pokemon(int id, String name, String t1, String t2, int total, int hp, int atk, int def, int sp_at, int sp_de, int speed)
	{
		this.id = id;
		this.name = name;
		this.types = new String[]{t1, t2};
		this.total = total;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.sp_atk = sp_at;
		this.sp_def = sp_de;
		this.speed = speed;
	}
	@Override
	public String toString() 
	{
		String stats = 	"\n\nID: " + id + 
						"\nName: " + name  + 
						"\nType(s): " + types[0]  + "-" + types[1] + 
						"\nTotal: " + total  + 
						"\nHP: " + hp  + 
						"\nAtk: " + atk + 
						"\nDef: " + def + 
						"\nSP Atk: " + sp_atk + 
						"\nSP Def: " + sp_def + 
						"\nSpeed: " + speed;
		return stats;
	}
	public int hp()
	{
		return this.hp;
	}
}
