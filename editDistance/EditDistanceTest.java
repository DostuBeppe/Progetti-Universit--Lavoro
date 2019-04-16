package editDistance;

import static org.junit.Assert.*;
import static editDistance.EditDistance.*;

import org.junit.Test;

public class EditDistanceTest {

  @Test
  public void testDistance_emptyString() {
    assertEquals(6, edit_distance("pioppo", new String()));
  }

  @Test
  public void testDistance_emptyStrings() {
    assertEquals(0, edit_distance(new String(), new String()));
  }

  @Test
  public void testDistance_sameString() {
    assertEquals(0, edit_distance("pioppo", "pioppo"));
  }

  @Test
  public void testDistance_1Del() {
    assertEquals(1, edit_distance("casa", "cassa"));
  }

  @Test
  public void testDistance_1Ins() {
    assertEquals(1, edit_distance("casta", "casa"));
  }

  @Test
  public void testDistance_1InsINV() {
    assertEquals(1, edit_distance("casa", "casta"));
  }

  @Test
  public void testDistance_1Del_1Ins() {
    assertEquals(2, edit_distance("casa", "cara"));
  }

  @Test
  public void testDistance_3Del_1Ins() {
    assertEquals(4, edit_distance("tassa", "passato"));
  }

  
  //---//
  @Test
  public void testDistanceDP_emptyString() {
    assertEquals(6, edit_distance_dyn("pioppo", new String()));
  }

  @Test
  public void testDistanceDP_emptyStrings() {
    assertEquals(0, edit_distance_dyn(new String(), new String()));
  }

  @Test
  public void testDistanceDP_sameString() {
    assertEquals(0, edit_distance_dyn("pioppo", "pioppo"));
  }

  @Test
  public void testDistanceDP_1Del() {
    assertEquals(1, edit_distance_dyn("casa", "cassa"));
  }

  @Test
  public void testDistanceDP_1Ins() {
    assertEquals(1, edit_distance_dyn("casta", "casa"));
  }

  @Test
  public void testDistanceDP_1InsINV() {
    assertEquals(1, edit_distance_dyn("casa", "casta"));
  }

  @Test
  public void testDistanceDP_1Del_1Ins() {
    assertEquals(2, edit_distance_dyn("casa", "cara"));
  }

  @Test
  public void testDistanceDP_3Del_1Ins() {
    assertEquals(4, edit_distance_dyn("tassa", "passato"));
  }

}
