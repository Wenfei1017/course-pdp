package edu.neu.ccs.cs5010;

import sun.plugin.dom.exception.WrongDocumentException;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * created by xwenfei on 11/16/2017
 */
public class ReadCSVFile {
    private String givenFileName;
    private final int resort = 0;
    private final int day = 1;
    private final int skierID = 2;
    private final int liftID = 3;
    private final int timeStamp = 4;

    public ReadCSVFile(String fileName){
        this.givenFileName = fileName;
    }

    /**
     *
     * @param csvFile the file contains all the information we needed
     * @return a hashmap, K is skier's ID, V is a list of lift which that skiers ride
     * @throws IOException
     */
    public List<HashMap> readInfoFromFile(String csvFile) throws IOException {
        List<HashMap> mapList = new ArrayList<>();
        HashMap<String,String> IDPairMap = new HashMap<>();
        HashMap<String, List<String>> skierInfoMap = new HashMap<>();
        HashMap<Integer,Integer> liftHourMap = new HashMap<>();
        InputStream inputStream = new FileInputStream(csvFile);
        Reader rder = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(rder);
        String[] info;
        String line = null;
        if(csvFile == null){
            throw new IllegalArgumentException("Template file should not be null");
        }
        try{
            while((line= reader.readLine())!=null && line.length() > 0){
                String[] rowInfo = line.split(",");
                info = new String[4];
                if(!skierInfoMap.containsKey(rowInfo[skierID])) {
                        List<String> liftIDList = new ArrayList<>();
                        liftIDList.add(rowInfo[liftID]);
                        skierInfoMap.put(rowInfo[skierID], liftIDList);
                        IDPairMap.put(rowInfo[skierID], rowInfo[liftID]);
                        liftHourMap.put(getHour(rowInfo[4]),Integer.parseInt(rowInfo[liftID]));
                }
                else{
                    skierInfoMap.get(rowInfo[skierID]).add(rowInfo[liftID]);
                }

            }
            reader.close();
        }catch (Exception e) {
            e.printStackTrace();

        }
        mapList.add(skierInfoMap);
        mapList.add(getTotalVerticalforEachID(skierInfoMap));
        mapList.add(IDPairMap);
        mapList.add(liftHourMap);
        //System.out.println(testCount);
        return mapList;
    }

    public int getHour(String timeInFile) throws IOException{
        int hour;
        double time = Double.parseDouble(timeInFile);
        if(time < 1 || time > 360) throw new IllegalArgumentException(
                "time wrong in file"
        );
        if (time <= 60) hour = 1;
        else if (time > 60 && time <= 120) hour = 2;
        else if (time > 120 && time <= 180) hour = 3;
        else if (time > 180 && time <= 240) hour = 4;
        else if (time > 240 && time <= 300) hour = 5;
        else hour = 6;
        return hour;
    }

    /**
     *
     * @param
     * @return a map, K is the skier's ID,which is unique. V is the total vertical number he/she ride the lift
     */
    public HashMap<String,Integer> getTotalVerticalforEachID(HashMap<String,List<String>> skierInfoMap) {
        HashMap<String, Integer> verticalSumMap = new HashMap<>();

        int liftIDRange = 0;
        //double verticalNum = 0;

        for (HashMap.Entry entry : skierInfoMap.entrySet()) {
            int verticalSum = 0;
            String skierID = (String) entry.getKey();
            //System.out.println(skierID);
            for (int i = 0; i < skierInfoMap.get(skierID).size(); i++) {
                int verticalNum = 0;
                try {
                int liftType = Integer.parseInt(skierInfoMap.get(skierID).get(i));

                if(liftType >= 1 && liftType <= 10) verticalNum = 200;
                else if(liftType >= 11 && liftType <= 20) verticalNum = 300;
                else if(liftType >= 21 && liftType <= 30) verticalNum = 400;
                else if(liftType >= 31 && liftType <= 40) verticalNum = 500;}
                catch (NumberFormatException e) {
                    System.out.println("not a number");
                }
                    verticalSum = verticalSum + verticalNum;
            }
                verticalSumMap.put(skierID, verticalSum);
        }
        return verticalSumMap;
    }

    public List<Map.Entry<String, Integer>> sortByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        return list;
    }
}
