package ru.naumen.perfhouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.naumen.sd40.log.parser.DBCloseException;
import ru.naumen.sd40.log.parser.ParseBuilder;

import java.io.IOException;
import java.text.ParseException;

@Controller
public class ParseContoller {

    @Autowired
    ParseBuilder builder;

    @RequestMapping(path = "/parse", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity parse(@RequestParam(name = "db") String db,
                                @RequestParam(name = "parse_mode") String mode,
                                @RequestParam(name = "filepath") String filePath,
                                @RequestParam(name = "timezone") String timeZone,
                                @RequestParam(name = "need_logging") String needLogging) throws ParseException, DBCloseException, IOException {

        builder.setDbConnection(db, needLogging.equals("yes")).parse(mode, filePath, timeZone);

        return new ResponseEntity<>("Parsing is done", HttpStatus.OK);

    }
}
