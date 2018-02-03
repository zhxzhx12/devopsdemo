package my.prct.gradle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */

@Controller
public class Library {
  public boolean someLibraryMethod() {
    return true;
  }

  public boolean oneMethodReturnFalse() {
    return false;
  }

  //    @RequestMapping("/greeting")
  @RequestMapping(path = "/greeting", method = RequestMethod.GET)
  public String greeting(@RequestParam(value = "name", required = false, defaultValue = "world") String name,
      Model model) {

    model.addAttribute("name", name);
    return "greeting";
  }

}
