package com.astontech.nlp.nlg;

import simplenlg.framework.*;
import simplenlg.lexicon.*;
import simplenlg.realiser.english.*;
import simplenlg.phrasespec.*;
import simplenlg.features.*;

import java.util.HashMap;

/**
 * Created by Bipin on 8/1/2016.
 *
 * walk along of the tutorial here:     https://github.com/simplenlg/simplenlg/wiki/Section-0-%E2%80%93-SimpleNLG-Tutorial
 *
 */
public class HelloNLG {

    static Lexicon lexicon = Lexicon.getDefaultLexicon();
    static NLGFactory nlgFactory = new NLGFactory(lexicon);
    static Realiser realiser = new Realiser(lexicon);

    public static void main(String[] args) {

        simpleClause();
        System.out.println("=========================");
        simpleComplements();
        System.out.println("=========================");
        multipleClauses();


    }

    public static void simpleClause() {

        SPhraseSpec phraseSpec = nlgFactory.createClause();
        phraseSpec.setSubject("Bipin");
        phraseSpec.setVerb("program");
        phraseSpec.setObject("the computer");

        String output = realiser.realiseSentence(phraseSpec);
        System.out.println("BASE: \t\t\t\t" + output);

        //setting past tense
        phraseSpec.setFeature(Feature.TENSE, Tense.PAST);
        output = realiser.realiseSentence(phraseSpec);
        System.out.println("PAST TENSE: \t\t" + output);

        //setting future tense
        phraseSpec.setFeature(Feature.TENSE, Tense.FUTURE);
        output = realiser.realiseSentence(phraseSpec);
        System.out.println("FUTURE TENSE: \t\t" + output);

        //making sentence negated
        phraseSpec.setFeature(Feature.NEGATED, true);
        output = realiser.realiseSentence(phraseSpec);
        System.out.println("NEGATED: \t\t\t" + output);

        //generate a simple yes/no question
        phraseSpec.setFeature(Feature.NEGATED, false);      //un-negate from previous example.
        phraseSpec.setFeature(Feature.INTERROGATIVE_TYPE, InterrogativeType.YES_NO);
        output = realiser.realiseSentence(phraseSpec);
        System.out.println("YES/NO QUESTION: \t" + output);

        //generate a simple WH question.
        phraseSpec.setFeature(Feature.INTERROGATIVE_TYPE, InterrogativeType.WHO_OBJECT);
        output = realiser.realiseSentence(phraseSpec);
        System.out.println("WHO OBJECT: \t\t" + output);

        //generate a simple WH question.
        phraseSpec.setFeature(Feature.INTERROGATIVE_TYPE, InterrogativeType.WHO_SUBJECT);
        output = realiser.realiseSentence(phraseSpec);
        System.out.println("WHO SUBJECT: \t\t" + output);
    }


    public static void simpleComplements() {

        SPhraseSpec phraseSpec = nlgFactory.createClause();
        phraseSpec.setSubject("I");
        phraseSpec.setVerb("code");
        phraseSpec.setObject("Java Web Application");

        String output = realiser.realiseSentence(phraseSpec);
        System.out.println("BASE: \t\t\t\t" + output);

        phraseSpec.addComplement("very professionally");
        phraseSpec.addComplement("despite the lack of documentation");

        output = realiser.realiseSentence(phraseSpec);
        System.out.println("WITH COMPLEMENTS: \t" + output);
    }

    public static void multipleClauses() {
        SPhraseSpec s1 = nlgFactory.createClause("my cat", "like", "fish");
        SPhraseSpec s2 = nlgFactory.createClause("my dog", "like", "big bones");
        SPhraseSpec s3 = nlgFactory.createClause("my horse", "like", "grass");

        CoordinatedPhraseElement c = nlgFactory.createCoordinatedPhrase();
        c.addCoordinate(s1);
        c.addCoordinate(s2);
        c.addCoordinate(s3);

        String output = realiser.realiseSentence(c);
        System.out.println("JOINED BY CONJUNCTION: \t" + output);


        SPhraseSpec p = nlgFactory.createClause("I", "be", "happy");
        SPhraseSpec q = nlgFactory.createClause("I", "eat", "fish");

        q.setFeature(Feature.COMPLEMENTISER, "because");
        q.setFeature(Feature.TENSE, Tense.PAST);
        p.addComplement(q);

        String output1 = realiser.realiseSentence(p);  //Realiser created earlier
        System.out.println("SUBORDINATE CLAUSES: \t" + output1);

    }
}
