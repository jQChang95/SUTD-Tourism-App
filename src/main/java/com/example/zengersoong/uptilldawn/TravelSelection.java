package com.example.zengersoong.uptilldawn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Zenger Soong on 30/11/2017.
 */


/**
 * Created by yanglei on 2017/11/30.
 */
class myNode {
    double time;
    double value;
    String location;
    String transport;

    public myNode(String location, String transport, double value, double time) {
        this.transport = transport;
        this.location = location;
        this.time = time;
        this.value = value;
    }
}

class checkedNode {
    double time;
    double value;
    String locationFrom;
    String locationTo;

    public checkedNode(String locationFrom, String locationTo, double value, double time) {
        this.locationFrom = locationFrom;
        this.locationTo = locationTo;
        this.time = time;
        this.value = value;
    }
}

public class TravelSelection {
    public void public_transport(HashMap<String[],double[]> public_trasportlist){
        String[][] l = new String[100][2];
        double[][] i= new double[100][2];

        l[0][0] = "Marina Bay Sands";
        l[0][1] = "Singapore Flyer";
        i[0][0] = 0.83;
        i[0][1] = 17;
        public_trasportlist.put(l[0],i[0]);

        l[1][0] = "Marina Bay Sands";
        l[1][1] = "VivoCity";
        i[1][0] = 1.18;
        i[1][1] = 26;
        public_trasportlist.put(l[1],i[1]);

        l[2][0] = "Marina Bay Sands";
        l[2][1] = "Resorts World Sentosa";
        i[2][0] = 4.03;
        i[2][1] = 35;
        public_trasportlist.put(l[2],i[2]);

        l[3][0] = "Marina Bay Sands";
        l[3][1] = "Buddha Tooth Relic Temple and Museum";
        i[3][0] = 0.88;
        i[3][1] = 19;
        public_trasportlist.put(l[3],i[3]);

        l[4][0] = "Marina Bay Sands";
        l[4][1] = "Singapore Zoo";
        i[4][0] = 1.96;
        i[4][1] = 84;
        public_trasportlist.put(l[4],i[4]);

        l[5][0] = "Marina Bay Sands";
        l[5][1] = "Gardens by the Bay";
        i[5][0] = 0.88;
        i[5][1] = 10;
        public_trasportlist.put(l[5],i[5]);

        l[6][0] = "Marina Bay Sands";
        l[6][1] = "Orchard Road";
        i[6][0] = 1.28;
        i[6][1] = 32;
        public_trasportlist.put(l[6],i[6]);

        l[7][0] = "Singapore Flyer";
        l[7][1] = "Marina Bay Sands";
        i[7][0] = 0.83;
        i[7][1] = 17;
        public_trasportlist.put(l[7],i[7]);

        l[8][0] = "Singapore Flyer";
        l[8][1] = "VivoCity";
        i[8][0] = 1.26;
        i[8][1] = 31;
        public_trasportlist.put(l[8],i[8]);

        l[9][0] = "Singapore Flyer";
        l[9][1] = "Resorts World Sentosa";
        i[9][0] = 4.03;
        i[9][1] = 38;
        public_trasportlist.put(l[9],i[9]);

        l[10][0] = "Singapore Flyer";
        l[10][1] = "Buddha Tooth Relic Temple and Museum";
        i[10][0] = 0.98;
        i[10][1] = 24;
        public_trasportlist.put(l[10],i[10]);

        l[11][0] = "Singapore Flyer";
        l[11][1] = "Singapore Zoo";
        i[11][0] = 1.89;
        i[11][1] = 85;
        public_trasportlist.put(l[11],i[11]);

        l[12][0] = "VivoCity";
        l[12][1] = "Marina Bay Sands";
        i[12][0] = 1.18;
        i[12][1] = 24;
        public_trasportlist.put(l[12],i[12]);
        l[13][0] = "VivoCity";
        l[13][1] = "Singapore Flyer";
        i[13][0] = 1.26;
        i[13][1] = 29;
        public_trasportlist.put(l[13],i[13]);
        l[14][0] = "VivoCity";
        l[14][1] = "Resorts World Sentosa";
        i[14][0] = 2.00;
        i[14][1] = 10;
        public_trasportlist.put(l[14],i[14]);
        l[15][0] = "VivoCity";
        l[15][1] = "Buddha Tooth Relic Temple and Museum";
        i[15][0] = 0.98;
        i[15][1] = 18;
        public_trasportlist.put(l[15],i[15]);
        l[16][0] = "VivoCity";
        l[16][1] = "Singapore Zoo";
        i[16][0] = 1.99;
        i[16][1] = 85;
        public_trasportlist.put(l[16],i[16]);
        l[17][0] = "Resorts World Sentosa";
        l[17][1] = "Marina Bay Sands";
        i[17][0] = 1.18;
        i[17][1] = 33;
        public_trasportlist.put(l[17],i[17]);
        l[18][0] = "Resorts World Sentosa";
        l[18][1] = "Singapore Flyer";
        i[18][0] = 1.26;
        i[18][1] = 38;
        public_trasportlist.put(l[18],i[18]);
        l[19][0] = "Resorts World Sentosa";
        l[19][1] = "VivoCity";
        i[19][0] = 0;
        i[19][1] = 10;
        public_trasportlist.put(l[19],i[19]);
        l[20][0] = "Resorts World Sentosa";
        l[20][1] = "Buddha Tooth Relic Temple and Museum";
        i[20][0] = 0.98;
        i[20][1] = 27;
        public_trasportlist.put(l[20],i[20]);
        l[21][0] = "Resorts World Sentosa";
        l[21][1] = "Singapore Zoo";
        i[21][0] = 1.99;
        i[21][1] = 92;
        public_trasportlist.put(l[21],i[21]);
        l[22][0] = "Buddha Tooth Relic Temple and Museum";
        l[22][1] = "Marina Bay Sands";
        i[22][0] = 0.88;
        i[22][1] = 18;
        public_trasportlist.put(l[22],i[22]);
        l[23][0] = "Buddha Tooth Relic Temple and Museum";
        l[23][1] = "Singapore Flyer";
        i[23][0] = 0.98;
        i[23][1] = 23;
        public_trasportlist.put(l[23],i[23]);
        l[24][0] = "Buddha Tooth Relic Temple and Museum";
        l[24][1] = "VivoCity";
        i[24][0] = 0.98;
        i[24][1] = 19;
        public_trasportlist.put(l[24],i[24]);
        l[25][0] = "Buddha Tooth Relic Temple and Museum";
        l[25][1] = "Resorts World Sentosa";
        i[25][0] = 3.98;
        i[25][1] = 28;
        public_trasportlist.put(l[25],i[25]);
        l[26][0] = "Buddha Tooth Relic Temple and Museum";
        l[26][1] = "Singapore Zoo";
        i[26][0] = 1.91;
        i[26][1] = 83;
        public_trasportlist.put(l[26],i[26]);
        l[27][0] = "Singapore Zoo";
        l[27][1] = "Marina Bay Sands";
        i[27][0] = 1.88;
        i[27][1] = 86;
        public_trasportlist.put(l[27],i[27]);
        l[28][0] = "Singapore Zoo";
        l[28][1] = "Singapore Flyer";
        i[28][0] = 1.96;
        i[28][1] = 87;
        public_trasportlist.put(l[28],i[28]);
        l[29][0] = "Singapore Zoo";
        l[29][1] = "VivoCity";
        i[29][0] = 2.11;
        i[29][1] = 86;
        public_trasportlist.put(l[29],i[29]);
        l[30][0] = "Singapore Zoo";
        l[30][1] = "Resorts World Sentosa";
        i[30][0] = 4.99;
        i[30][1] = 96;
        public_trasportlist.put(l[30],i[30]);
        l[31][0] = "Singapore Zoo";
        l[31][1] = "Buddha Tooth Relic Temple and Museum";
        i[31][0] = 1.91;
        i[31][1] = 84;
        public_trasportlist.put(l[31],i[31]);

        l[32][0] = "Singapore Flyer";
        l[32][1] = "Gardens by the Bay";
        i[32][0] = 0.88;
        i[32][1] = 11;
        public_trasportlist.put(l[32],i[32]);

        l[33][0] = "Singapore Flyer";
        l[33][1] = "Orchard Road";
        i[33][0] = 1.28;
        i[33][1] = 34;
        public_trasportlist.put(l[33],i[33]);

        l[34][0] = "VivoCity";
        l[34][1] = "Gardens by the Bay";
        i[34][0] = 1.26;
        i[34][1] = 34;
        public_trasportlist.put(l[34],i[34]);

        l[35][0] = "VivoCity";
        l[35][1] = "Orchard Road";
        i[35][0] = 1.18;
        i[35][1] = 29;
        public_trasportlist.put(l[35],i[35]);

        l[36][0] = "Resorts World Sentosa";
        l[36][1] = "Gardens by the Bay";
        i[36][0] = 0.88;
        i[36][1] = 14;
        public_trasportlist.put(l[36],i[36]);

        l[37][0] = "Resorts World Sentosa";
        l[37][1] = "Orchard Road";
        i[37][0] = 1.98;
        i[37][1] = 60;
        public_trasportlist.put(l[37],i[37]);

        l[38][0] = "Buddha Tooth Relic Temple and Museum";
        l[38][1] = "Gardens by the Bay";
        i[38][0] = 0.88;
        i[38][1] = 9;
        public_trasportlist.put(l[38],i[38]);

        l[39][0] = "Singapore Zoo";
        l[39][1] = "Gardens by the Bay";
        i[39][0] = 1.26;
        i[39][1] = 26;
        public_trasportlist.put(l[39],i[39]);

        l[40][0] = "Singapore Zoo";
        l[40][1] = "Orchard Road";
        i[40][0] = 1.99;
        i[40][1] = 86;
        public_trasportlist.put(l[40],i[40]);

        l[41][0] = "Gardens by the Bay";
        l[41][1] = "Marina Bay Sands";
        i[41][0] = 0.88;
        i[41][1] = 3;
        public_trasportlist.put(l[41],i[41]);

        l[42][0] = "Gardens by the Bay";
        l[42][1] = "Singapore Flyer";
        i[42][0] = 0.88;
        i[42][1] = 8;
        public_trasportlist.put(l[42],i[42]);

        l[43][0] = "Gardens by the Bay";
        l[43][1] = "VivoCity";
        i[43][0] = 1.26;
        i[43][1] = 34;
        public_trasportlist.put(l[43],i[43]);

        l[44][0] = "Gardens by the Bay";
        l[44][1] = "Resorts World Sentosa";
        i[44][0] = 2.00;
        i[44][1] = 67;
        public_trasportlist.put(l[44],i[44]);

        l[45][0] = "Gardens by the Bay";
        l[45][1] = "Buddha Tooth Relic Temple and Museum";
        i[45][0] = 1.18;
        i[45][1] = 24;
        public_trasportlist.put(l[45],i[45]);

        l[46][0] = "Gardens by the Bay";
        l[46][1] = "Singapore Zoo";
        i[46][0] = 1.99;
        i[46][1] = 98;
        public_trasportlist.put(l[46],i[46]);

        l[47][0] = "Gardens by the Bay";
        l[47][1] = "Orchard Road";
        i[47][0] = 1.18;
        i[47][1] = 35;
        public_trasportlist.put(l[47],i[47]);

        l[48][0] = "Orchard Road";
        l[48][1] = "Marina Bay Sands";
        i[48][0] = 1.26;
        i[48][1] = 34;
        public_trasportlist.put(l[48],i[48]);

        l[49][0] = "Orchard Road";
        l[49][1] = "Singapore Flyer";
        i[49][0] = 1.26;
        i[49][1] = 31;
        public_trasportlist.put(l[49],i[49]);

        l[50][0] = "Orchard Road";
        l[50][1] = "VivoCity";
        i[50][0] = 1.18;
        i[50][1] = 27;
        public_trasportlist.put(l[50],i[50]);

        l[51][0] = "Orchard Road";
        l[51][1] = "Resorts World Sentosa";
        i[51][0] = 3.56;
        i[51][1] = 56;
        public_trasportlist.put(l[51],i[51]);

        l[52][0] = "Orchard Road";
        l[52][1] = "Buddha Tooth Relic Temple and Museum";
        i[52][0] = 1.18;
        i[52][1] = 25;
        public_trasportlist.put(l[52],i[52]);

        l[53][0] = "Orchard Road";
        l[53][1] = "Singapore Zoo";
        i[53][0] = 1.86;
        i[53][1] = 86;
        public_trasportlist.put(l[53],i[53]);

        l[54][0] = "Orchard Road";
        l[54][1] = "Gardens by the Bay";
        i[54][0] = 1.28;
        i[54][1] = 36;
        public_trasportlist.put(l[54],i[54]);

        l[55][0] = "Buddha Tooth Relic Temple and Museum";
        l[55][1] = "Orchard Road";
        i[55][0] = 1.18;
        i[55][1] = 27;
        public_trasportlist.put(l[55],i[55]);

    }


    public void taxi(HashMap<String[],double[]> taxilist){
        String[][] l1 = new String[100][2];
        double[][] i1 = new double[100][2];
        l1[0][0] = "Marina Bay Sands";
        l1[0][1] = "Singapore Flyer";
        i1[0][0] = 3.22;
        i1[0][1] = 3;
        taxilist.put(l1[0],i1[0]);
        l1[1][0] = "Marina Bay Sands";
        l1[1][1] = "VivoCity";
        i1[1][0] = 6.96;
        i1[1][1] = 14;
        taxilist.put(l1[1],i1[1]);
        l1[2][0] = "Marina Bay Sands";
        l1[2][1] = "Resorts World Sentosa";
        i1[2][0] = 8.50;
        i1[2][1] = 19;
        taxilist.put(l1[2],i1[2]);
        l1[3][0] = "Marina Bay Sands";
        l1[3][1] = "Buddha Tooth Relic Temple and Museum";
        i1[3][0] = 4.98;
        i1[3][1] = 8;
        taxilist.put(l1[3],i1[3]);
        l1[4][0] = "Marina Bay Sands";
        l1[4][1] = "Singapore Zoo";
        i1[4][0] = 18.40;
        i1[4][1] = 30;
        taxilist.put(l1[4],i1[4]);
        l1[5][0] = "Singapore Flyer";
        l1[5][1] = "Marina Bay Sands";
        i1[5][0] = 4.32;
        i1[5][1] = 6;
        taxilist.put(l1[5],i1[5]);
        l1[6][0] = "Singapore Flyer";
        l1[6][1] = "VivoCity";
        i1[6][0] = 7.84;
        i1[6][1] = 13;
        taxilist.put(l1[6],i1[6]);
        l1[7][0] = "Singapore Flyer";
        l1[7][1] = "Resorts World Sentosa";
        i1[7][0] = 9.38;
        i1[7][1] = 18;
        taxilist.put(l1[7],i1[7]);
        l1[8][0] = "Singapore Flyer";
        l1[8][1] = "Buddha Tooth Relic Temple and Museum";
        i1[8][0] = 4.76;
        i1[8][1] = 8;
        taxilist.put(l1[8],i1[8]);
        l1[9][0] = "Singapore Flyer";
        l1[9][1] = "Singapore Zoo";
        i1[9][0] = 18.18;
        i1[9][1] = 29;
        taxilist.put(l1[9],i1[9]);
        l1[10][0] = "VivoCity";
        l1[10][1] = "Marina Bay Sands";
        i1[10][0] = 8.30;
        i1[10][1] = 12;
        taxilist.put(l1[10],i1[10]);
        l1[11][0] = "VivoCity";
        l1[11][1] = "Singapore Flyer";
        i1[11][0] = 7.96;
        i1[11][1] = 14;
        taxilist.put(l1[11],i1[11]);
        l1[12][0] = "VivoCity";
        l1[12][1] = "Resorts World Sentosa";
        i1[12][0] = 4.54;
        i1[12][1] = 9;
        taxilist.put(l1[12],i1[12]);
        l1[13][0] = "VivoCity";
        l1[13][1] = "Buddha Tooth Relic Temple and Museum";
        i1[13][0] = 6.42;
        i1[13][1] = 11;
        taxilist.put(l1[13],i1[13]);
        l1[14][0] = "VivoCity";
        l1[14][1] = "Singapore Zoo";
        i1[14][0] = 22.58;
        i1[14][1] = 31;
        taxilist.put(l1[14],i1[14]);
        l1[15][0] = "Resorts World Sentosa";
        l1[15][1] = "Marina Bay Sands";
        i1[15][0] = 8.74;
        i1[15][1] = 13;
        taxilist.put(l1[15],i1[15]);
        l1[16][0] = "Resorts World Sentosa";
        l1[16][1] = "Singapore Flyer";
        i1[16][0] = 8.40;
        i1[16][1] = 14;
        taxilist.put(l1[16],i1[16]);
        l1[17][0] = "Resorts World Sentosa";
        l1[17][1] = "VivoCity";
        i1[17][0] = 3.22;
        i1[17][1] = 4;
        taxilist.put(l1[17],i1[17]);
        l1[18][0] = "Resorts World Sentosa";
        l1[18][1] = "Buddha Tooth Relic Temple and Museum";
        i1[18][0] = 6.64;
        i1[18][1] = 12;
        taxilist.put(l1[18],i1[18]);
        l1[19][0] = "Resorts World Sentosa";
        l1[19][1] = "Singapore Zoo";
        i1[19][0] = 22.80;
        i1[19][1] = 32;
        taxilist.put(l1[19],i1[19]);
        l1[20][0] = "Buddha Tooth Relic Temple and Museum";
        l1[20][1] = "Marina Bay Sands";
        i1[20][0] = 5.32;
        i1[20][1] = 7;
        taxilist.put(l1[20],i1[20]);
        l1[21][0] = "Buddha Tooth Relic Temple and Museum";
        l1[21][1] = "Singapore Flyer";
        i1[21][0] = 4.76;
        i1[21][1] = 8;
        taxilist.put(l1[21],i1[21]);
        l1[22][0] = "Buddha Tooth Relic Temple and Museum";
        l1[22][1] = "VivoCity";
        i1[22][0] = 4.98;
        i1[22][1] = 9;
        taxilist.put(l1[22],i1[22]);
        l1[23][0] = "Buddha Tooth Relic Temple and Museum";
        l1[23][1] = "Resorts World Sentosa";
        i1[23][0] = 6.52;
        i1[23][1] = 14;
        taxilist.put(l1[23],i1[23]);
        l1[24][0] = "Buddha Tooth Relic Temple and Museum";
        l1[24][1] = "Singapore Zoo";
        i1[24][0] = 18.40;
        i1[24][1] = 30;
        taxilist.put(l1[24],i1[24]);
        l1[25][0] = "Singapore Zoo";
        l1[25][1] = "Marina Bay Sands";
        i1[25][0] = 22.48;
        i1[25][1] = 32;
        taxilist.put(l1[25],i1[25]);
        l1[26][0] = "Singapore Zoo";
        l1[26][1] = "Singapore Flyer";
        i1[26][0] = 19.40;
        i1[26][1] = 29;
        taxilist.put(l1[26],i1[26]);
        l1[27][0] = "Singapore Zoo";
        l1[27][1] = "VivoCity";
        i1[27][0] = 21.48;
        i1[27][1] = 32;
        taxilist.put(l1[27],i1[27]);
        l1[28][0] = "Singapore Zoo";
        l1[28][1] = "Resorts World Sentosa";
        i1[28][0] = 23.68;
        i1[28][1] = 36;
        taxilist.put(l1[28],i1[28]);
        l1[29][0] = "Singapore Zoo";
        l1[29][1] = "Buddha Tooth Relic Temple and Museum";
        i1[29][0] = 21.60;
        i1[29][1] = 30;
        taxilist.put(l1[29],i1[29]);
        l1[30][0] = "Marina Bay Sands";
        l1[30][1] = "Gardens by the Bay";
        i1[30][0] = 8.11;
        i1[30][1] = 7;
        taxilist.put(l1[30],i1[30]);
        l1[31][0] = "Marina Bay Sands";
        l1[31][1] = "Orchard Road";
        i1[31][0] = 8.30;
        i1[31][1] = 8;
        taxilist.put(l1[31],i1[31]);
        l1[32][0] = "Singapore Flyer";
        l1[32][1] = "Gardens by the Bay";
        i1[32][0] = 8.67;
        i1[32][1] = 11;
        taxilist.put(l1[32],i1[32]);
        l1[33][0] = "Singapore Flyer";
        l1[33][1] = "Orchard Road";
        i1[33][0] = 7.50;
        i1[33][1] = 6;
        taxilist.put(l1[33],i1[33]);
        l1[34][0] = "VivoCity";
        l1[34][1] = "Gardens by the Bay";
        i1[34][0] = 12.30;
        i1[34][1] = 11;
        taxilist.put(l1[34],i1[34]);
        l1[35][0] = "VivoCity";
        l1[35][1] = "Orchard Road";
        i1[35][0] = 12.40;
        i1[35][1] = 13;
        taxilist.put(l1[35],i1[35]);
        l1[36][0] = "Resorts World Sentosa";
        l1[36][1] = "Gardens by the Bay";
        i1[36][0] = 15.50;
        i1[36][1] = 14;
        taxilist.put(l1[36],i1[36]);
        l1[37][0] = "Resorts World Sentosa";
        l1[37][1] = "Orchard Road";
        i1[37][0] = 16.20;
        i1[37][1] = 17;
        taxilist.put(l1[37],i1[37]);
        l1[38][0] = "Buddha Tooth Relic Temple and Museum";
        l1[38][1] = "Gardens by the Bay";
        i1[38][0] = 10.70;
        i1[38][1] = 9;
        taxilist.put(l1[38],i1[38]);
        l1[39][0] = "Buddha Tooth Relic Temple and Museum";
        l1[39][1] = "Orchard Road";
        i1[39][0] = 7.80;
        i1[39][1] = 7;
        taxilist.put(l1[39],i1[39]);
        l1[40][0] = "Singapore Zoo";
        l1[40][1] = "Gardens by the Bay";
        i1[40][0] = 28.00;
        i1[40][1] = 26;
        taxilist.put(l1[40],i1[40]);
        l1[41][0] = "Singapore Zoo";
        l1[41][1] = "Orchard Road";
        i1[41][0] = 23.60;
        i1[41][1] = 21;
        taxilist.put(l1[41],i1[41]);
        l1[42][0] = "Gardens by the Bay";
        l1[42][1] = "Marina Bay Sands";
        i1[42][0] = 8.20;
        i1[42][1] = 5;
        taxilist.put(l1[42],i1[42]);
        l1[43][0] = "Gardens by the Bay";
        l1[43][1] = "Singapore Flyer";
        i1[43][0] = 8.70;
        i1[43][1] = 6;
        taxilist.put(l1[43],i1[43]);
        l1[44][0] = "Gardens by the Bay";
        l1[44][1] = "Resorts World Sentosa";
        i1[44][0] = 14.80;
        i1[44][1] = 12;
        taxilist.put(l1[44],i1[44]);
        l1[45][0] = "Gardens by the Bay";
        l1[45][1] = "Buddha Tooth Relic Temple and Museum";
        i1[45][0] = 9.70;
        i1[45][1] = 8;
        taxilist.put(l1[45],i1[45]);
        l1[46][0] = "Gardens by the Bay";
        l1[46][1] = "Singapore Zoo";
        i1[46][0] = 14.50;
        i1[46][1] = 26;
        taxilist.put(l1[46],i1[46]);
        l1[47][0] = "Gardens by the Bay";
        l1[47][1] = "Orchard Road";
        i1[47][0] = 10.30;
        i1[47][1] = 10;
        taxilist.put(l1[47],i1[47]);
        l1[48][0] = "Gardens by the Bay";
        l1[48][1] = "VivoCity";
        i1[48][0] = 7.40;
        i1[48][1] = 9;
        taxilist.put(l1[48],i1[48]);
        l1[49][0] = "Orchard Road";
        l1[49][1] = "Marina Bay Sands";
        i1[49][0] = 9.70;
        i1[49][1] = 8;
        taxilist.put(l1[49],i1[49]);
        l1[50][0] = "Orchard Road";
        l1[50][1] = "Singapore Flyer";
        i1[50][0] = 9.20;
        i1[50][1] = 7;
        taxilist.put(l1[50],i1[50]);
        l1[51][0] = "Orchard Road";
        l1[51][1] = "Resorts World Sentosa";
        i1[51][0] = 18.20;
        i1[51][1] = 16;
        taxilist.put(l1[51],i1[51]);
        l1[52][0] = "Orchard Road";
        l1[52][1] = "Buddha Tooth Relic Temple and Museum";
        i1[52][0] = 12.40;
        i1[52][1] = 9;
        taxilist.put(l1[52],i1[52]);
        l1[53][0] = "Orchard Road";
        l1[53][1] = "Singapore Zoo";
        i1[53][0] = 16.70;
        i1[53][1] = 21;
        taxilist.put(l1[53],i1[53]);
        l1[54][0] = "Orchard Road";
        l1[54][1] = "Gardens by the Bay";
        i1[54][0] = 15.80;
        i1[54][1] = 14;
        taxilist.put(l1[54],i1[54]);
        l1[55][0] = "Orchard Road";
        l1[55][1] = "VivoCity";
        i1[55][0] = 10.20;
        i1[55][1] = 12;
        taxilist.put(l1[55],i1[55]);

    }

    public void footway(HashMap<String[],double[]> footlist){
        String[][] l2 = new String[100][2];
        double[][] i2 = new double[100][2];
        l2[0][0] = "Marina Bay Sands";
        l2[0][1] = "Singapore Flyer";
        i2[0][0] = 0;
        i2[0][1] = 14;
        footlist.put(l2[0],i2[0]);
        l2[1][0] = "Marina Bay Sands";
        l2[1][1] = "VivoCity";
        i2[1][0] = 0;
        i2[1][1] = 69;
        footlist.put(l2[1],i2[1]);
        l2[2][0] = "Marina Bay Sands";
        l2[2][1] = "Resorts World Sentosa";
        i2[2][0] = 0;
        i2[2][1] = 76;
        footlist.put(l2[2],i2[2]);
        l2[3][0] = "Marina Bay Sands";
        l2[3][1] = "Buddha Tooth Relic Temple and Museum";
        i2[3][0] = 0;
        i2[3][1] = 28;
        footlist.put(l2[3],i2[3]);
        l2[4][0] = "Marina Bay Sands";
        l2[4][1] = "Singapore Zoo";
        i2[4][0] = 0;
        i2[4][1] = 269;
        footlist.put(l2[4],i2[4]);
        //here
        l2[5][0] = "Marina Bay Sands";
        l2[5][1] = "Gardens by the Bay";
        i2[5][0] = 0;
        i2[5][1] = 11;
        footlist.put(l2[5],i2[5]);
        l2[6][0] = "Marina Bay Sands";
        l2[6][1] = "Orchard Road";
        i2[6][0] = 0;
        i2[6][1] = 48;
        footlist.put(l2[6],i2[6]);


        l2[7][0] = "Singapore Flyer";
        l2[7][1] = "Marina Bay Sands";
        i2[7][0] = 0;
        i2[7][1] = 14;
        footlist.put(l2[7],i2[7]);
        l2[8][0] = "Singapore Flyer";
        l2[8][1] = "VivoCity";
        i2[8][0] = 0;
        i2[8][1] = 81;
        footlist.put(l2[8],i2[8]);
        l2[9][0] = "Singapore Flyer";
        l2[9][1] = "Resorts World Sentosa";
        i2[9][0] = 0;
        i2[9][1] = 88;
        footlist.put(l2[9],i2[9]);
        l2[10][0] = "Singapore Flyer";
        l2[10][1] = "Buddha Tooth Relic Temple and Museum";
        i2[10][0] = 0;
        i2[10][1] = 39;
        footlist.put(l2[10],i2[10]);
        l2[11][0] = "Singapore Flyer";
        l2[11][1] = "Singapore Zoo";
        i2[11][0] = 0;
        i2[11][1] = 264;
        footlist.put(l2[11],i2[11]);

        l2[12][0] = "Singapore Flyer";
        l2[12][1] = "Gardens by the Bay";
        i2[12][0] = 0;
        i2[12][1] = 14;
        footlist.put(l2[12],i2[12]);
        l2[13][0] = "Singapore Flyer";
        l2[13][1] = "Orchard Road";
        i2[13][0] = 0;
        i2[13][1] = 45;
        footlist.put(l2[13],i2[13]);

        l2[14][0] = "VivoCity";
        l2[14][1] = "Marina Bay Sands";
        i2[14][0] = 0;
        i2[14][1] = 69;
        footlist.put(l2[14],i2[14]);
        l2[15][0] = "VivoCity";
        l2[15][1] = "Singapore Flyer";
        i2[15][0] = 0;
        i2[15][1] = 81;
        footlist.put(l2[15],i2[15]);
        l2[16][0] = "VivoCity";
        l2[16][1] = "Resorts World Sentosa";
        i2[16][0] = 0;
        i2[16][1] = 12;
        footlist.put(l2[16],i2[16]);
        l2[17][0] = "VivoCity";
        l2[17][1] = "Buddha Tooth Relic Temple and Museum";
        i2[17][0] = 0;
        i2[17][1] = 47;
        footlist.put(l2[17],i2[17]);
        l2[18][0] = "VivoCity";
        l2[18][1] = "Singapore Zoo";
        i2[18][0] = 0;
        i2[18][1] = 270;
        footlist.put(l2[18],i2[18]);

        l2[19][0] = "VivoCity";
        l2[19][1] = "Gardens by the Bay";
        i2[19][0] = 0;
        i2[19][1] = 76;
        footlist.put(l2[19],i2[19]);
        l2[20][0] = "VivoCity";
        l2[20][1] = "Orchard Road";
        i2[20][0] = 0;
        i2[20][1] = 77;
        footlist.put(l2[20],i2[20]);

        l2[21][0] = "Resorts World Sentosa";
        l2[21][1] = "Marina Bay Sands";
        i2[21][0] = 0;
        i2[21][1] = 76;
        footlist.put(l2[21],i2[21]);
        l2[22][0] = "Resorts World Sentosa";
        l2[22][1] = "Singapore Flyer";
        i2[22][0] = 0;
        i2[22][1] = 88;
        footlist.put(l2[22],i2[22]);
        l2[23][0] = "Resorts World Sentosa";
        l2[23][1] = "VivoCity";
        i2[23][0] = 0;
        i2[23][1] = 12;
        footlist.put(l2[23],i2[23]);
        l2[24][0] = "Resorts World Sentosa";
        l2[24][1] = "Buddha Tooth Relic Temple and Museum";
        i2[24][0] = 0;
        i2[24][1] = 55;
        footlist.put(l2[24],i2[24]);
        l2[25][0] = "Resorts World Sentosa";
        l2[25][1] = "Singapore Zoo";
        i2[25][0] = 0;
        i2[25][1] = 285;
        footlist.put(l2[25],i2[25]);

        l2[26][0] = "Resorts World Sentosa";
        l2[26][1] = "Gardens by the Bay";
        i2[26][0] = 0;
        i2[26][1] = 106;
        footlist.put(l2[26],i2[26]);
        l2[27][0] = "Resorts World Sentosa";
        l2[27][1] = "Orchard Road";
        i2[27][0] = 0;
        i2[27][1] = 97;
        footlist.put(l2[27],i2[27]);

        l2[28][0] = "Buddha Tooth Relic Temple and Museum";
        l2[28][1] = "Marina Bay Sands";
        i2[28][0] = 0;
        i2[28][1] = 28;
        footlist.put(l2[28],i2[28]);
        l2[29][0] = "Buddha Tooth Relic Temple and Museum";
        l2[29][1] = "Singapore Flyer";
        i2[29][0] = 0;
        i2[29][1] = 39;
        footlist.put(l2[29],i2[29]);
        l2[30][0] = "Buddha Tooth Relic Temple and Museum";
        l2[30][1] = "VivoCity";
        i2[30][0] = 0;
        i2[30][1] = 47;
        footlist.put(l2[30],i2[30]);
        l2[31][0] = "Buddha Tooth Relic Temple and Museum";
        l2[31][1] = "Resorts World Sentosa";
        i2[31][0] = 0;
        i2[31][1] = 55;
        footlist.put(l2[31],i2[31]);
        l2[32][0] = "Buddha Tooth Relic Temple and Museum";
        l2[32][1] = "Singapore Zoo";
        i2[32][0] = 0;
        i2[32][1] = 264;
        footlist.put(l2[32],i2[32]);

        l2[33][0] = "Buddha Tooth Relic Temple and Museum";
        l2[33][1] = "Gardens by the Bay";
        i2[33][0] = 0;
        i2[33][1] = 32;
        footlist.put(l2[33],i2[33]);
        l2[34][0] = "Buddha Tooth Relic Temple and Museum";
        l2[34][1] = "Orchard Road";
        i2[34][0] = 0;
        i2[34][1] = 43;
        footlist.put(l2[34],i2[34]);

        l2[35][0] = "Singapore Zoo";
        l2[35][1] = "Marina Bay Sands";
        i2[35][0] = 0;
        i2[35][1] = 269;
        footlist.put(l2[35],i2[35]);
        l2[36][0] = "Singapore Zoo";
        l2[36][1] = "Singapore Flyer";
        i2[36][0] = 0;
        i2[36][1] = 264;
        footlist.put(l2[36],i2[36]);
        l2[37][0] = "Singapore Zoo";
        l2[37][1] = "VivoCity";
        i2[37][0] = 0;
        i2[37][1] = 270;
        footlist.put(l2[37],i2[37]);
        l2[38][0] = "Singapore Zoo";
        l2[38][1] = "Resorts World Sentosa";
        i2[38][0] = 0;
        i2[38][1] = 285;
        footlist.put(l2[38],i2[38]);
        l2[39][0] = "Singapore Zoo";
        l2[39][1] = "Buddha Tooth Relic Temple and Museum";
        i2[39][0] = 0;
        i2[39][1] = 264;
        footlist.put(l2[39],i2[39]);

        l2[40][0] = "Singapore Zoo";
        l2[40][1] = "Gardens by the Bay";
        i2[40][0] = 0;
        i2[40][1] = 282;
        footlist.put(l2[40],i2[40]);
        l2[41][0] = "Singapore Zoo";
        l2[41][1] = "Orchard Road";
        i2[41][0] = 0;
        i2[41][1] = 254;
        footlist.put(l2[41],i2[41]);

        l2[42][0] = "Gardens by the Bay";
        l2[42][1] = "Marina Bay Sands";
        i2[42][0] = 0;
        i2[42][1] = 4;
        footlist.put(l2[42],i2[42]);
        l2[43][0] = "Gardens by the Bay";
        l2[43][1] = "Singapore Flyer";
        i2[43][0] = 0;
        i2[43][1] = 11;
        footlist.put(l2[43],i2[43]);
        l2[45][0] = "Gardens by the Bay";
        l2[45][1] = "VivoCity";
        i2[45][0] = 0;
        i2[45][1] = 75;
        footlist.put(l2[45],i2[45]);
        l2[46][0] = "Gardens by the Bay";
        l2[46][1] = "Resorts World Sentosa";
        i2[46][0] = 0;
        i2[46][1] = 105;
        footlist.put(l2[46],i2[46]);
        l2[47][0] = "Gardens by the Bay";
        l2[47][1] = "Buddha Tooth Relic Temple and Museum";
        i2[47][0] = 0;
        i2[47][1] = 32;
        footlist.put(l2[47],i2[47]);

        l2[48][0] = "Gardens by the Bay";
        l2[48][1] = "Singapore Zoo";
        i2[48][0] = 0;
        i2[48][1] = 284;
        footlist.put(l2[48],i2[48]);

        l2[49][0] = "Gardens by the Bay";
        l2[49][1] = "Orchard Road";
        i2[49][0] = 0;
        i2[49][1] = 47;
        footlist.put(l2[49],i2[49]);


        l2[50][0] = "Orchard Road";
        l2[50][1] = "Marina Bay Sands";
        i2[50][0] = 0;
        i2[50][1] = 50;
        footlist.put(l2[50],i2[50]);
        l2[51][0] = "Orchard Road";
        l2[51][1] = "Singapore Flyer";
        i2[51][0] = 0;
        i2[51][1] = 45;
        footlist.put(l2[51],i2[51]);
        l2[52][0] = "Orchard Road";
        l2[52][1] = "VivoCity";
        i2[52][0] = 0;
        i2[52][1] = 77;
        footlist.put(l2[52],i2[52]);
        l2[53][0] = "Orchard Road";
        l2[53][1] = "Resorts World Sentosa";
        i2[53][0] = 0;
        i2[53][1] = 107;
        footlist.put(l2[53],i2[53]);
        l2[54][0] = "Orchard Road";
        l2[54][1] = "Buddha Tooth Relic Temple and Museum";
        i2[54][0] = 0;
        i2[54][1] = 42;
        footlist.put(l2[54],i2[54]);

        l2[55][0] = "Orchard Road";
        l2[55][1] = "Singapore Zoo";
        i2[55][0] = 0;
        i2[55][1] = 253;
        footlist.put(l2[55],i2[55]);

        l2[56][0] = "Orchard Road";
        l2[56][1] = "Gardens by the Bay";
        i2[56][0] = 0;
        i2[56][1] = 45;
        footlist.put(l2[56],i2[56]);



    }

    //TODO: add the database list here!

    public static void generatePerm(ArrayList<String> input, int index, ArrayList<ArrayList<String>> output) {
        if (input.size() - index == 1) {
            output.add(new ArrayList<String>(input));
        } else {
            for (int i = index; i < input.size(); i++) {
                Collections.swap(input, i, index);
                generatePerm(input, index + 1, output);
                Collections.swap(input, index, i);
            }
        }

    }


    public ArrayList<ArrayList<String>> brute(ArrayList<String> mlist, double budget) {
        HashMap<String[], double[]> public_trasportlist = new HashMap<String[], double[]>();
        String hotel = "Marina Bay Sands";
        public_transport(public_trasportlist);

        HashMap<String[], double[]> taxilist = new HashMap<>();
        taxi(taxilist);

        HashMap<String[], double[]> footlist = new HashMap<>();
        footway(footlist);


        final ArrayList<ArrayList<String>> alllist = new ArrayList<>(); // need to set it as final !!!!
        generatePerm(mlist, 0, alllist);


        ArrayList<String> result = new ArrayList<>();
        ArrayList<Double> timelist = new ArrayList<>();


        for (ArrayList<String> mylist : alllist) {
            ArrayList<String> location = new ArrayList<>();
            location.add(hotel);
            for (String k : mylist) {
                location.add(k);
            }

            location.add(hotel); // list from hotel to n-1 location to hotel

            Tree_Android Tree = new Tree_Android();
            ArrayList<Node> treelist = new ArrayList<>();
            treelist.add(new Node(location.get(0), "Starting", 0, 0));


            for (int j = 0; j < location.size() - 1; j++) {
                String[] check = new String[2];
                check[0] = location.get(j);
                check[1] = location.get(j + 1);


                for (int k = 0; k < Math.pow(3, j); k++) {
                    for (String[] key : public_trasportlist.keySet()) {
                        if (key[0].equals(check[0]) && key[1].equals(check[1])) {
                            Node node = new Node(key[1], "public_transport", public_trasportlist.get(key)[0], public_trasportlist.get(key)[1]);
                            treelist.add(node);
                        }
                    }
                    for (String[] key : taxilist.keySet()) {
                        if (key[0].equals(check[0]) && key[1].equals(check[1])) {
                            Node node = new Node(key[1], "taxi", taxilist.get(key)[0], taxilist.get(key)[1]);
                            treelist.add(node);
                        }
                    }
                    for (String[] key : footlist.keySet()) {
                        if (key[0].equals(check[0]) && key[1].equals(check[1])) {
                            Node node = new Node(key[1], "foot", footlist.get(key)[0], footlist.get(key)[1]);
                            treelist.add(node);
                        }
                    }
                }
            }

            Tree.FormTree(treelist, 0);

            HashMap<String[], double[]> thelist;
            String outp;
            String[] str = new String[2];
            double time = 9999;
            double fee = 0;

            thelist = Tree.getPaths(Tree.getRoot());
            for (String[] key : thelist.keySet()) {
                if (thelist.get(key)[1] <= budget) {
                    if (thelist.get(key)[0] < time) {
                        time = thelist.get(key)[0];
                        fee = thelist.get(key)[1];
                    }
                }
            }

            for (String[] key : thelist.keySet()) {
                if (thelist.get(key)[0] == time) {
                    str = key;
                }
            }


            outp = str[0] + "/" + str[1] + "/" + time + "/" + fee;
            result.add(outp);
            timelist.add(time);
        }
        double timeout = timelist.get(0);
        String resultString = result.get(0);
        for (int p = 1; p < timelist.size(); p++) {
            if (timelist.get(p) < timeout) {
                timeout = timelist.get(p);
                resultString = result.get(p);
            }
        }
        ArrayList<String> glist = new ArrayList<>(Arrays.asList(resultString.split("/")));
        ArrayList<ArrayList<String>> output = new ArrayList<>();
        ArrayList<String> loca = new ArrayList<>(Arrays.asList(glist.get(0).split("->")));
        ArrayList<String> tran = new ArrayList<>(Arrays.asList(glist.get(1).split("->")));
        ArrayList<String> rest = new ArrayList<>();
        rest.add(glist.get(2));
        rest.add(glist.get(3));
        output.add(loca);
        output.add(tran);
        output.add(rest);

        return output;
    }


    public checkedNode getkey(String[] inputlocation, HashMap<String[], double[]> inputtransport) {
        checkedNode output = null;
        for (String[] key : inputtransport.keySet()) {
            if (inputlocation[0].equals(key[0]) && inputlocation[1].equals(key[1])) {
                output = new checkedNode(key[0], key[1], inputtransport.get(key)[0], inputtransport.get(key)[1]);
            }
        }
        return output;
    }

    public ArrayList<ArrayList<String>> Algo(ArrayList<String> mlist, double budget) {
        HashMap<String[], double[]> public_transportlist = new HashMap<>();
        public_transport(public_transportlist);

        HashMap<String[], double[]> taxilist = new HashMap<>();
        taxi(taxilist);

        HashMap<String[], double[]> footlist = new HashMap<>();
        footway(footlist);


        ArrayList<String> location = new ArrayList<>();
        location.add("Marina Bay Sands");

        for (String k : mlist) {
            location.add(k);
        }

        ArrayList<String> listoforder = new ArrayList<>();
        location.add("Marina Bay Sands");

        String[] checklocation = new String[2];

        String locating = "";
        checkedNode checked;
        for (int i = 0; i < location.size() - 1; i++) {
            checklocation[0] = location.get(i);
            double timing = 9999;
            for (int j = i + 1; j < location.size(); j++) {
                checklocation[1] = location.get(j);
                if (checklocation[1].equals(location.get(0)) && i == 0) {
                    continue;
                } else {
                    checked = getkey(checklocation, footlist);
                    if ( checked == null ) {
                        throw new RuntimeException(String.format("checklocation = %s", checklocation));
                    }
                    if (checked.time < timing) {
                        timing = checked.time;
                        locating = checked.locationFrom;
                    }

                }
            }

            listoforder.add(locating);
        }
        listoforder.add("Marina Bay Sands");

        myNode[] edgelist = new myNode[location.size()];
        edgelist[0] = new myNode("Marina Bay Sands", "Starting", 0, 0);
        int start = 0;
        int end = location.size() - 1;
        checkedNode gettaxi1;
        checkedNode gettaxi2;
        checkedNode getpublic1;
        checkedNode getpublic2;
        checkedNode getfoot;
        checkedNode getfoot1;
        checkedNode gettransport;
        double budgetsave = budget * 0.25;
        for (int i = 0; i < listoforder.size() - 1; i++) {
            if (start == listoforder.size() - 1) {
                break;
            }
            String[] check = new String[2];
            if (start == 0) {
                check[0] = listoforder.get(end - 1);
                check[1] = listoforder.get(end);
                gettaxi1 = getkey(check, taxilist);
                if (gettaxi1.value <= budget && (budget - gettaxi1.value) >= budgetsave) {
                    myNode node = new myNode(gettaxi1.locationTo, "taxi", gettaxi1.value, gettaxi1.time);
                    budget -= gettaxi1.value;
                    edgelist[end] = node;
                    start = 1;
                } else {
                    getpublic1 = getkey(check, public_transportlist);
                    getfoot1 = getkey(check,footlist);
                    if(budget<getpublic1.value){
                        myNode node = new myNode(getfoot1.locationTo,"foot",getfoot1.value,getfoot1.time);
                        edgelist[end] = node;
                        start = 1;
                    }
                    else {
                        myNode node = new myNode(getpublic1.locationTo, "public_transport", getpublic1.value, getpublic1.time);
                        edgelist[end] = node;
                        budget -= getpublic1.value;
                        start = 1;
                    }
                }
            } else {
                check[0] = listoforder.get(start - 1);
                check[1] = listoforder.get(start);
                gettaxi2 = getkey(check, taxilist);
                if (gettaxi2.value <= budget && (budget - gettaxi2.value) >= budgetsave) {
                    myNode node = new myNode(gettaxi2.locationTo, "taxi", gettaxi2.value, gettaxi2.time);
                    edgelist[start] = node;
                    budget -= gettaxi2.value;
                    start++;
                } else {
                    double timepu;
                    double feepu;
                    gettransport = getkey(check, public_transportlist);
                    if ( gettransport == null) {
                        throw new RuntimeException("gettransport failed");
                    }
                    timepu = gettransport.time;
                    feepu = gettransport.value;
                    getfoot = getkey(check, footlist);
                    if (getfoot.time <= timepu || budget < feepu) {
                        myNode node = new myNode(getfoot.locationTo, "foot", getfoot.value, getfoot.time);
                        edgelist[start] = node;
                        start++;
                    } else {
                        getpublic2 = getkey(check, public_transportlist);
                        myNode node = new myNode(getpublic2.locationTo, "public_transport", getpublic2.value, getpublic2.time);
                        edgelist[start] = node;
                        budget -= getpublic2.value;
                        start++;
                    }
                }

            }
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        result.add(0, new ArrayList<String>());
        result.add(1, new ArrayList<String>());
        double time = 0;
        double transportfee = 0;

        for (int k = 0; k < edgelist.length; k++) {
            result.get(0).add(edgelist[k].location);
            result.get(1).add(edgelist[k].transport);
            time += edgelist[k].time;
            transportfee += edgelist[k].value;
        }
        ArrayList<String> li = new ArrayList<>();
        li.add("" + time);
        li.add("" + transportfee);
        result.add(li);
        return result;


    }
}
