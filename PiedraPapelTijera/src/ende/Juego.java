/**
 * Simula el juego de Piedra, Papel o tijera
 * @author Unai P
 * @version 1.0
 */

package ende;

public class Juego 
{
    public static void main(String args[])
    {
        Jugador p1=new Jugador(0,0);
        Jugador p2=new Jugador(0,0);
        boolean fin_de_juego=false;  
        Integer Rondasjugadas = 0;    // Numero de rondas jugadas
        Integer EXITOS_jugador1=p1.Exitos;
        Integer EXITOS_jugador2=p2.Exitos;
        Integer EmPaTeS = 0;
        String opcion_JUGADOR1, opcion_JUGADOR2;
        
        // Bucle de juego
        do
        {
            System.out.println("***** Ronda: " + Rondasjugadas+" *********************\n");
            System.out.println("Numero de empates: "+ EmPaTeS + "\n");
            opcion_JUGADOR1=p1.opcion_al_azar();
            System.out.println("Jugador 1: " + opcion_JUGADOR1+"\t Jugador 1 - Partidas ganadas: " + EXITOS_jugador1);
            opcion_JUGADOR2 = p2.opcion_al_azar();
            System.out.println("Jugador 2: " + opcion_JUGADOR2+"\t Jugador 2 - Partidas ganadas: " + EXITOS_jugador2);
            
            if((opcion_JUGADOR1.equals("piedra")) && (opcion_JUGADOR2.equals("papel"))){
                System.out.println("Jugador 2 GANA");
                EXITOS_jugador2 = ++p2.Exitos;  
            } else if((opcion_JUGADOR1.equals("papel")) && (opcion_JUGADOR2.equals("piedra"))){
            	EXITOS_jugador1 = ++p1.Exitos;
                System.out.println("Jugador 1 GANA");
            } else if((opcion_JUGADOR1.equals("piedra")) && (opcion_JUGADOR2.equals("tijeras"))){
            	EXITOS_jugador1 = ++p1.Exitos;
                System.out.println("Jugador 1 GANA");
            } else if((opcion_JUGADOR1.equals("tijeras")) && (opcion_JUGADOR2.equals("piedra"))){
            	EXITOS_jugador2 = ++p2.Exitos;
                System.out.println("Jugador 2 GANA");
            } else if((opcion_JUGADOR1.equals("tijeras")) && (opcion_JUGADOR2.equals("papel"))){
            	EXITOS_jugador1 = ++p1.Exitos;
                System.out.println("Jugador 1 GANA");
            } else if((opcion_JUGADOR1.equals("papel")) && (opcion_JUGADOR2.equals("tijeras"))){
            	EXITOS_jugador2 = ++p2.Exitos;
                System.out.println("Jugador 2 GANA");
            } 
            if(opcion_JUGADOR1 == opcion_JUGADOR2){
            	EmPaTeS++;
                System.out.println("\n\t\t\t Empate \n");
            }
            Rondasjugadas++;
            if((p1.Exitos>=3) || (p2.Exitos>=3)){
            	fin_de_juego=true;
                System.out.println("FIN DEL JUEGO!!");
            }
            System.out.println();
        } while(fin_de_juego!=true);
    }
}
/**
 *
 */
class Jugador{
	
    int Exitos;      // numero de partidas ganadas
    int winTotal;
    public Jugador(int queExitos, int queWin) {
    	Exitos = queExitos;
    	winTotal = queWin;
    }
    
    /**
     * Escoge piedra, papel o tijera al azar
     */
    public String opcion_al_azar()
    {
        String opcion="";
        Integer c = (int)(Math.random()*3);
        switch(c){
            case 0:
            	opcion=("piedra");
                break;
            case 1:
            	opcion=("papel");
                break;
            case 2:
            	opcion=("tijeras");
            	break;
        }
        return opcion;
    }
    public void setExitos() 
    {
        Exitos++;
    }
    public int getExitos() 
    {
        return(Exitos);
    }

}
