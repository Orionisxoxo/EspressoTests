@RunWith(AndroidJUnit4.class)
@SmallTest
public class LoginTest {

    private LoginFragment loginFragment = new LoginFragment();

    @Rule
    public ActivityTestRule<MainActivity> mainActivity
            = new ActivityTestRule<>(MainActivity.class, false, true);

    @Before
    public void setUp() {
        mainActivity
                .getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentContainer, loginFragment)
                .commit();
    }

    @Test
    public void chooseCorrectPrefix() {
        BaristaSleepInteractions.sleep(500);

        onView(allOf(ViewMatchers.withId(R.id.arrow), isDescendantOfA(withId(R.id.prefixSpinner))))
                .check(matches(isDisplayed()))
                .perform(click());
    }

    @Test
    public void fillPhoneNumberFieldWithCorrectPhoneNumber() {
        onView(withId(R.id.phoneNumberText))
                .perform(click(), clearText(), typeText(ValuesForTests.CorrectPhoneNumber));
    }

    @Test
    public void fillPasswordFieldWithCorrectPassword() {
        onView(withId(R.id.passwordText))
                .perform(click(), clearText(), typeText(ValuesForTests.CorrectPassword));
    }

    @Test
    public void clickResetPasswordTextViewToOpenResetPassswordView() {
        onView(withId(R.id.forgotPassword))
                .perform(click());
    }

    @Test
    public void clickLoginButton() {
        BaristaSleepInteractions.sleep(300);

        onView(withId(R.id.loginButton))
                .check(matches(isEnabled()))
                .perform(click());
    }

    @Test
    public void clickRegistrationButtonToOpenRegistrationView() {
        onView(withId(R.id.register))
                .perform(click());
    }
}
