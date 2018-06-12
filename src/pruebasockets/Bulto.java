/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasockets;

/**
 *
 * @author psistemas
 */
public class Bulto {
    
    private String serialnumber,timestamp,unit;
    
    private double height,length,weight = 0,width,volume;
    
    private int NumBulto;

    public int getNumBulto() {
        return NumBulto;
    }

    public void setNumBulto(int NumBulto) {
        this.NumBulto = NumBulto;
    }
    
    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
    
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getSerialNumber() {
        return serialnumber;
    }

    public void setSerialNumer(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public String getTimestamp() {
        return timestamp; 
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
