package org.enoir.rulest.ruleengine;

import org.enoir.rulest.model.Fact;

import java.util.List;

/**
 * Created by frank on 2015/4/18.
 */
public interface Parser {
    List<Fact> parseFacts();
}
