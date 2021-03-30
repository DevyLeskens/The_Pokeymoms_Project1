package domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(Suite.class)
@SuiteClasses({PuntTest.class, SpelerTest.class, CirkelTest.class, RechthoekTest.class, DriehoekTest.class, LijnStukTest.class, OmhullendeTest.class, TekeningTest.class})
public class AllTests {

}
