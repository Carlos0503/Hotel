package PaqC06;

import java.util.Scanner;

public class Hotel {
    Reserva [][] hotel;


    public Hotel() {
        this.hotel = new Reserva[8][6];
        int i;
        int j;
        for(i=0;i<8;i++){
            for(j=0;j<6;j++) {
                this.hotel[i][j] = null;
            }
        }
    }
    public Reserva getHotel(int i,int j){
        return this.hotel[i][j];
    }
    public void setHotel(int i,int j,Reserva r){
        this.hotel[i][j] = r;
    }
    

    public String toString(){
        int i;
        int j;
        String matriz [][] = new String[8][6];
        for(i=0;i<8;i++){
            for(j=0;j<6;j++){
                if(this.hotel[i][j]==null){
                    matriz[i][j]="L  ";
                }
                else matriz[i][j]="R  ";
            }
        }
        return  "=================================" + '\n' +
                "__ |  |  ┌-┐  ──┰──  ┌──  │    __" + '\n' +
                "__ |──|  | |    │    ┠──  │    __" + '\n' +
                "__ |  |  └-┘    │    └──  └─── __" + '\n' +
                "=================================" + '\n' +
                " " +  matriz[7][0] + "|  " + matriz [7][1] + "|  " + matriz [7][2] + "|  " + matriz[7][3] + "|  " + matriz [7][4] + "|  " + matriz [7][5]+'\n' +
                "_________________________________" + '\n' +
                " " + matriz[6][0] + "|  " + matriz [6][1] + "|  " + matriz [6][2] + "|  " + matriz[6][3] + "|  " + matriz [6][4] + "|  " + matriz [6][5]+'\n' +
                "_________________________________" + '\n' +
                " " + matriz[5][0] + "|  " + matriz [5][1] + "|  " + matriz [5][2] + "|  " + matriz[5][3] + "|  " + matriz [5][4] + "|  " + matriz [5][5]+'\n'+
                "_________________________________" + '\n' +
                " " + matriz[4][0] + "|  " + matriz [4][1] + "|  " + matriz [4][2] + "|  " + matriz[4][3] + "|  " + matriz [4][4] + "|  " + matriz [4][5]+'\n' +
                "_________________________________" + '\n' +
                " " + matriz[3][0] + "|  " + matriz [3][1] + "|  " + matriz [3][2] + "|  " + matriz[3][3] + "|  " + matriz [3][4] + "|  " + matriz [3][5]+'\n' +
                "_________________________________" + '\n' +
                " " + matriz[2][0] + "|  " + matriz [2][1] + "|  " + matriz [2][2] + "|  " + matriz[2][3] + "|  " + matriz [2][4] + "|  " + matriz [2][5]+'\n'+
                "_________________________________" + '\n' +
                " " + matriz[1][0] + "|  " + matriz [1][1] + "|  " + matriz [1][2] + "|  " + matriz[1][3] + "|  " + matriz [1][4] + "|  " + matriz [1][5]+'\n' +
                "_________________________________" + '\n' +
                " " + matriz[0][0] + "|  " + matriz [0][1] + "|  " + matriz [0][2] + "|  " + matriz[0][3] + "|  " + matriz [0][4] + "|  " + matriz [0][5]+'\n';
    }
    public double habDisponible(){
        int i;
        int j;
        double k;
        for (i=0;i<8;i++){
            for (j=0;j<6;j++){
                if(this.hotel[i][j]==null){
                    i++;
                    j++;
                    k = i + (double)j/10;
                    return k;
                }
            }
        }
        return 0;
    }
    private double habPlantaDisponible(int i){ //
        int j;
        double k;
        if (i==0){
            for (i=0;i<5;i++){
                for (j=0;j<6;j++){
                    if(this.hotel[i][j]==null){
                        i++;
                        j++;
                        k = i + (double)j/10;
                        return k;
                    }
                }
            }
        }
        else for(j=0;j<6;j++){
            if(this.hotel[i][j]==null){
                i++;
                j++;
                k = i + (double)j/10;
                return k;
            }
        }
        return 0;
    }

    public double [] tipoHab(int [] tipo){
        int i;
        double k;
        double [] hab = new double[48];
        for(i=0;i<tipo.length;i++){
            if(tipo[i] == 2){
                k = habPlantaDisponible(7);
                hab[i] = k;
            }
            if(tipo[i] == 1){
                k = habPlantaDisponible(5);
                if(k == 0){
                    k = habPlantaDisponible(6);
                    hab[i] = k;
                }
                else hab[i] = k;
            }
            if(tipo[i] == 0){
                k = habPlantaDisponible(0);
                hab[i] = k;
            }
        }
        return hab;
    }
    public void hacerReserva(int [] tipo,String dni, String nombre, String apellidos, String telefono, String tarjeta,
    String fechaent, String fechasal, String regali){
        int h;
        double [] hab = tipoHab(tipo);
        for(h=0;h<48;h++) {
            double k = hab[h];
            if (k!=0.0) {
                int i = (int) k;
                int j = (int) ((k - i) * 10);
                i--;

                rellenarHab(i,j,dni,nombre,apellidos,telefono,tarjeta,fechaent,fechasal,regali);
            }
        }
    }
    protected void rellenarHab(int i,int j,String dni,String nombre,String apellidos,String telefono,String tarjeta,String fechaent,String fechasal,String regali){
        Reserva r = new Reserva(dni,nombre,apellidos,telefono,tarjeta,fechaent,fechasal,regali);
        setHotel(i,j,r);
    }
    public void eliminarRes(String dni){
        int i;
        int j;
        String d;
        for(i=0;i<8;i++){
            for(j=0;j<6;j++){
                d = this.hotel[i][j].getDni();
                if(d == dni) {
                    this.hotel[i][j] = null;
                }
            }
        }

    }
    public Reserva comprobarDNI(String dni){
        int i;
        int j;
        Reserva r;
        for(i=0;i<8;i++){
            for(j=0;j<6;j++){
                if(this.hotel[i][j].getDni()==dni){
                    r = this.hotel[i][j];
                    return r;
                }
            }
        }
        System.out.println("El dni no coincide con ninguna reserva del hotel");
        return null;
    }
}
