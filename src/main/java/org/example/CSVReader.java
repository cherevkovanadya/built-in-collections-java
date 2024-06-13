package org.example;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CSVReader {

    public static <T> List<T> getListFromCSVFile(String filename, Class<T> type) throws IOException {

        try(Reader reader = new BufferedReader(new FileReader("src/main/resources/" + filename))) {
            CsvToBean<T> csvReader = new CsvToBeanBuilder<T>(reader)
                    .withType(type)
                    .withSeparator(';')
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build();
            return csvReader.parse();
        }
    }
}