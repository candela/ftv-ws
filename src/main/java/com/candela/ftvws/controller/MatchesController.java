package com.candela.ftvws.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.candela.ftvws.bean.Match;
import com.candela.ftvws.bean.MatchList;

@Controller
public class MatchesController {

	private static final String XML_VIEW_NAME = "matchXML";

	@RequestMapping(method = RequestMethod.GET, value = "/match/{id}")
	public ModelAndView getMatch(@PathVariable String id) {
		Match match = new Match("local" + id, "visitor" + id);
		return new ModelAndView(XML_VIEW_NAME, "match", match);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/matches")
	public ModelAndView getAllMatches() {
		List<Match> matches = new ArrayList<Match>();
		matches.add(new Match("local 1", "visitor 1"));
		matches.add(new Match("local 2", "visitor 2"));
		matches.add(new Match("local 3", "visitor 3"));
		MatchList matchList = new MatchList(matches);
		return new ModelAndView(XML_VIEW_NAME, "matchList", matchList);
	}

}
