/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jdbc;

/**
 *
 * @author diego
 */
public class LogUso {
    private String id_LogUso;
    private String fk_maquina;
    private String fk_empresa;
    private String fk_usuario;
    private String dataLog;
    private String horaInicio;
    private String horaFinal;

    public LogUso(String id_LogUso, String fk_maquina, String fk_empresa, String fk_usuario, String dataLog, String horaInicio, String horaFinal) {
        this.id_LogUso = id_LogUso;
        this.fk_maquina = fk_maquina;
        this.fk_empresa = fk_empresa;
        this.fk_usuario = fk_usuario;
        this.dataLog = dataLog;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }

    
    
    public LogUso(){
        
    }

    @Override
    public String toString() {
        return "ObjetoLog{" +
                "id_LogUso ='" + id_LogUso + '\'' +
                "fk_maquina ='" + fk_maquina + '\'' +
                "fk_empresa ='" + fk_empresa + '\'' +
                "fk_usuario ='" + fk_usuario + '\'' +
                "dataLog ='" + dataLog + '\'' +
                "horaInicio ='" + horaInicio + '\'' +
                "horaFinal ='" + horaInicio + '\'' +
                '}';
    }

    public String getId_LogUso() {
        return id_LogUso;
    }

    public void setId_LogUso(String id_LogUso) {
        this.id_LogUso = id_LogUso;
    }

    public String getFk_maquina() {
        return fk_maquina;
    }

    public void setFk_maquina(String fk_maquina) {
        this.fk_maquina = fk_maquina;
    }

    public String getFk_empresa() {
        return fk_empresa;
    }

    public void setFk_empresa(String fk_empresa) {
        this.fk_empresa = fk_empresa;
    }

    public String getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(String fk_usuario) {
        this.fk_usuario = fk_usuario;
    }

    public String getDataLog() {
        return dataLog;
    }

    public void setDataLog(String dataLog) {
        this.dataLog = dataLog;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    
}
