package com.example.dao;

import com.example.dto.ObservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by vinit on 3/31/17.
 */
@Component
public class ObservationDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void store(List<ObservationDto> obervations, String series_id) {

        try {
            System.out.println(jdbcTemplate.getClass());

            String query = "\n" +
                    "INSERT INTO `FRED-series-observation-table`\n" +
                    "(`series_id`,\n" +
                    "`realtime_start`,\n" +
                    "`realtime_end`, `date`,\n" +
                    "`value`)\n" +
                    "SELECT `series_id`, ?,\n" +
                    "?, ?, ? from `data-series-reference-table` WHERE series_symbol = ?;\n";


            for (ObservationDto observationDto : obervations) {

                try {
                    jdbcTemplate.update(query, observationDto.getRealtimeStart(), observationDto.getRealtimeEnd(), observationDto.getDate(), Double.parseDouble(observationDto.getValue()), series_id);
                } catch (NumberFormatException e) {

                    e.printStackTrace();
                    continue;

                }

            }


        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void clear() {

        jdbcTemplate.execute("TRUNCATE  `FRED-series-observation-table`");
    }

    public List<ObservationDto> pull(String series_id, Date fromYear, Date toYear) {


        List<ObservationDto> list = jdbcTemplate.query("SELECT * FROM `FRED-series-observation-table` T1 INNER JOIN `data-series-reference-table` T2 ON T1.series_id = T2.series_id WHERE series_symbol = ? AND date BETWEEN ? AND ?  ", new Object[]{series_id, fromYear, toYear}, new RowMapper() {
            @Override
            public ObservationDto mapRow(ResultSet resultSet, int i) throws SQLException {
                ObservationDto o = new ObservationDto();
                o.setDate(resultSet.getDate("date"));
                o.setRealtimeEnd(resultSet.getDate("realtime_start"));
                o.setRealtimeStart(resultSet.getDate("realtime_start"));
                o.setValue(String.valueOf(resultSet.getDouble("value")));
                return o;
            }
        });

        return list;
    }

}
