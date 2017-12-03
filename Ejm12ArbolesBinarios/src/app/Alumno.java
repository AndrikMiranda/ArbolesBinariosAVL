package app;

import java.util.Comparator;

public class Alumno implements Comparable<Alumno>, Comparator<Alumno> {
	private double promedio;
	@Override
	public int compare(Alumno arg0, Alumno arg1) {
		// TODO Auto-generated method stub
		return arg0.compareTo(arg1);
	}

	@Override
	public int compareTo(Alumno o) {
		// TODO Auto-generated method stub
		if (this.promedio == o.promedio) return 0;
		else if (this.promedio > o.promedio) return 1;
		else 
			return -1;
		
	}

}
