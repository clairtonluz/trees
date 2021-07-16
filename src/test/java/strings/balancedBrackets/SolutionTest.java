package strings.balancedBrackets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void shouldBeBalanced() {
        Assertions.assertEquals("YES", Solution.isBalanced("{[()]}"));
    }

    @Test
    void shouldBeBalanced2() {
        Assertions.assertEquals("YES", Solution.isBalanced("{{[[(())]]}}"));
    }

    @Test
    void shouldBeNotBalanced() {
        Assertions.assertEquals("NO", Solution.isBalanced("{[(])}"));
    }


    @Test
    void testCase0() {
        Assertions.assertEquals("NO", Solution.isBalanced("}][}}(}][))]"));
        Assertions.assertEquals("YES", Solution.isBalanced("[](){()}"));
        Assertions.assertEquals("YES", Solution.isBalanced("()"));
        Assertions.assertEquals("YES", Solution.isBalanced("({}([][]))[]()"));
        Assertions.assertEquals("NO", Solution.isBalanced("{)[](}]}]}))}(())("));
        Assertions.assertEquals("NO", Solution.isBalanced("([[)"));
    }

    @Test
    void testCase18() {
        Assertions.assertEquals("YES", Solution.isBalanced("{[()]}"));
        Assertions.assertEquals("NO", Solution.isBalanced("{[(])}"));
        Assertions.assertEquals("YES", Solution.isBalanced("{{[[(())]]}}"));
    }
}