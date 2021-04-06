public class TresEnRayas {
    
    protected String tabla[][];

    public TresEnRayas(){

        this.tabla = new String[3][3];
        this.inicializarTabla();
    }

    public void inicializarTabla(){

        for (int i = 0; i < this.tabla.length; i++) {
            for (int j = 0; j < this.tabla[i].length; j++) {
                
                this.tabla[i][j] = ".";
            }
        }
    }

    public String mostrarTabla(){

        String res = "";

        for (int i = 0; i < this.tabla.length; i++) {
            for (int j = 0; j < this.tabla[i].length; j++) {
                
                res += "  "+this.tabla[i][j]+"  ";
            }
            res += "\n";
        }

        return res;
    }

    public void rellenarHueco(int posX, int posY, String forma){

        this.tabla[posX][posY] = forma;
    }

    
    public boolean comprobarHueco(int posX, int posY){

        if (this.tabla[posX][posY].equals(".")){
            
            return true;
        }
        else{

            return false;
        }
    }


    public boolean comprobarTablero(String forma){

        if (this.tabla[0][0].equals(forma) && this.tabla[1][1].equals(forma) && this.tabla[2][2].equals(forma)){
            return true;
        }

        if (this.tabla[2][0].equals(forma) && this.tabla[1][1].equals(forma) && this.tabla[0][2].equals(forma)){
            return true;
        }

        
        for (int i = 0; i < 3; i++) {
            
            if (this.tabla[i][0].equals(forma) && this.tabla[i][1].equals(forma) && this.tabla[i][2].equals(forma)){
                return true;
            }

            if (this.tabla[0][i].equals(forma) && this.tabla[1][i].equals(forma) && this.tabla[2][i].equals(forma)){
                return true;
            }
        }

        return false;
    }
    
}
