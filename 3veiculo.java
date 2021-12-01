veiculo.java

package projetoJava;

public class Veiculo {
    private Usuario motorista;
    private String placa;
    private String marca;
    private int id;


    public Veiculo(Usuario motorista, String placa, String marca,int id) {
        this.motorista = motorista;
        this.placa = placa;
        this.marca = marca;
        this.id = id;
    }

    public Usuario getMotorista() {
        return this.motorista;
    }

    public void setMotorista(Usuario motorista) {
        this.motorista = motorista;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Motorista: "+getMotorista()+"; Veiculo: Placa - "+getPlaca()+", Marca - "+getMarca();

    }

    public String resultadoConsulta(){
        return "Motorista: "+getMotorista()+"; Veiculo: Placa - "+getPlaca()+", Marca - "+getMarca()+", ID - "+getId();
    }
    
}