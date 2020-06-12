@RunWith(AndroidJUnit4.class)
@SmallTest
public class RegistrationTest {

    private RegistrationFragment registrationFragment = new RegistrationFragment();

    @Rule
    public ActivityTestRule<MainActivity> mainActivity
            = new ActivityTestRule<>(MainActivity.class, false, true);

    @Before
    public void setUp() {
        mainActivity
                .getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentContainer, registrationFragment)
                .commit();
    }

    @Test
    public void fillEmailFieldWithCorrectAddress() {
        onView(withId(R.id.emailField))
                .perform(click(), clearText(), typeText(ValuesForTests.CorrectEmail));
    }

    @Test
    public void chooseCorrectPrefix() {
        onView(allOf(withId(R.id.arrow), isDescendantOfA(withId(R.id.prefixSpinner))))
                .check(matches(isDisplayed()))
                .perform(click());
    }

    @Test
    public void fillEmailFieldWithCorrectPhoneNumber() {
        onView(withId(R.id.phoneNumberField))
                .perform(click(), clearText(), typeText(ValuesForTests.CorrectPhoneNumber));
    }

    @Test
    public void fillPasswordFieldWithCorrectPassword() {
        onView(withId(R.id.passwordField))
                .perform(click(), clearText(), typeText(ValuesForTests.CorrectPassword));
    }

    @Test
    public void fillRepeatedPasswordFieldWithCorrectPassword() {
        onView(withId(R.id.repeatedPasswordField))
                .perform(click(), clearText(), typeText(ValuesForTests.CorrectPassword));
    }

    @Test
    public void checkTermsAndConditionsCheckBox() {
        onView(withId(R.id.termsAndConditionsRadioButton))
                .check(matches(isNotChecked()))
                .perform(click());
    }

    @Test
    public void checkNewsletterCheckBox() {
        onView(withId(R.id.newsletterRadioButton))
                .check(matches(isNotChecked()))
                .perform(click());
    }

    @Test
    public void clickRegistrationButton() {
        onView(withId(R.id.registerButton))
                .perform(scrollTo())
                .check(matches(isEnabled()))
                .perform(click());
    }
}
