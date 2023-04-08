package fileManager;

import juego.Juego.Dificultad;

public class SistemaPuntaje {

	private static Integer cantCentesimas = 0;
	private static Integer cantMin = 0;
	private static Integer cantSeg = 0;
	private static Double dificultadObetenida = 0.0;
	private static Double puntajeTotal = 0.0;
	
	public static Double obtenerPuntaje(String tiempo, Dificultad dificultad) {
		
		String[] tiempos = tiempo.split(":");
		
		try {
			cantCentesimas = Integer.valueOf(tiempos[2]);
			cantSeg = Integer.valueOf(tiempos[1]);
			cantMin = Integer.valueOf(tiempos[0]);
		} catch (Exception e) {
			return 0.0;
		}
		
		dificultadObetenida = obtenerDificultad(dificultad);
		puntajeTotal = 10000.0;
		puntajeTotal = puntajeTotal - ((  (cantMin+1) * dificultadObetenida * dificultadObetenida) + ( cantSeg * dificultadObetenida) + (cantCentesimas*1)); 

		if(puntajeTotal <= 0) {
			return 0.0;
		}
		
		return puntajeTotal/100;
	}
	
	

	private static double obtenerDificultad(Dificultad dificultad) {
	
		switch (dificultad) {
		case FACIL: {
			return 60.0;
		}
		case NORMAL: {
			return 40.0;
		}
		case DIFICIL: {
			return 20.0;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + dificultad);
		}
	}



//	public static void main(String[] args) {
//		
//		System.out.println( "Puntaje F: " + obtenerPuntaje("00:30:00", Dificultad.FACIL)  );
//		System.out.println( "Puntaje M: " + obtenerPuntaje("00:30:00", Dificultad.NORMAL)  );
//		System.out.println( "Puntaje D: " + obtenerPuntaje("00:30:00", Dificultad.DIFICIL)  );
//		System.out.println( "Puntaje F: " + obtenerPuntaje("01:10:00", Dificultad.FACIL)  );
//		System.out.println( "Puntaje M: " + obtenerPuntaje("01:10:00", Dificultad.NORMAL)  );
//		System.out.println( "Puntaje D: " + obtenerPuntaje("01:10:00", Dificultad.DIFICIL)  );
//		System.out.println( "Puntaje F: " + obtenerPuntaje("02:10:00", Dificultad.FACIL)  );
//		System.out.println( "Puntaje M: " + obtenerPuntaje("02:10:00", Dificultad.NORMAL)  );
//		System.out.println( "Puntaje D: " + obtenerPuntaje("02:10:00", Dificultad.DIFICIL)  );
//
//
//
//	}

}
