package String_Functions;
public class StringHandlingDemo {
public static void main(String[] args) {
// Basic String Creation
System.out.println(&quot;=== String Creation and Basic Operations ===&quot;);
String str1 = &quot;Hello, World!&quot;;
String str2 = new String(&quot;Java Programming&quot;);
System.out.println(&quot;Original strings:&quot;);
System.out.println(&quot;str1: &quot; + str1);
System.out.println(&quot;str2: &quot; + str2);
// Length and Character Access
System.out.println(&quot;\n=== Length and Character Access ===&quot;);
System.out.println(&quot;Length of str1: &quot; + str1.length());
System.out.println(&quot;Character at index 4 in str1: &quot; + str1.charAt(4));
// String Comparison
System.out.println(&quot;\n=== String Comparison ===&quot;);
String str3 = &quot;hello, world!&quot;;
System.out.println(&quot;str1 equals str3: &quot; + str1.equals(str3));
System.out.println(&quot;str1 equals str3 (ignore case): &quot; + str1.equalsIgnoreCase(str3));
System.out.println(&quot;str1 compareTo str3: &quot; + str1.compareTo(str3));
// Searching in Strings
System.out.println(&quot;\n=== String Searching ===&quot;);
System.out.println(&quot;Index of &#39;World&#39; in str1: &quot; + str1.indexOf(&quot;World&quot;));
System.out.println(&quot;Last index of &#39;o&#39; in str1: &quot; + str1.lastIndexOf(&#39;o&#39;));
System.out.println(&quot;str1 contains &#39;Hello&#39;: &quot; + str1.contains(&quot;Hello&quot;));
// Substring Operations
System.out.println(&quot;\n=== Substring Operations ===&quot;);
System.out.println(&quot;Substring of str1 (7 to end): &quot; + str1.substring(7));
System.out.println(&quot;Substring of str1 (0 to 5): &quot; + str1.substring(0, 5));
// String Modification
System.out.println(&quot;\n=== String Modification ===&quot;);
System.out.println(&quot;Uppercase: &quot; + str1.toUpperCase());
System.out.println(&quot;Lowercase: &quot; + str1.toLowerCase());
System.out.println(&quot;Replace &#39;World&#39; with &#39;Java&#39;: &quot; + str1.replace(&quot;World&quot;, &quot;Java&quot;));

// Whitespace Handling
System.out.println(&quot;\n=== Whitespace Handling ===&quot;);
String spacedString = &quot; Trimming Example &quot;;
System.out.println(&quot;Original: &#39;&quot; + spacedString + &quot;&#39;&quot;);
System.out.println(&quot;After trim: &#39;&quot; + spacedString.trim() + &quot;&#39;&quot;);
// String Concatenation
System.out.println(&quot;\n=== String Concatenation ===&quot;);
String concat1 = &quot;Hello&quot;;
String concat2 = &quot;World&quot;;
System.out.println(&quot;Using + operator: &quot; + concat1 + &quot; &quot; + concat2);
System.out.println(&quot;Using concat(): &quot; + concat1.concat(&quot; &quot;).concat(concat2));
// String Splitting
System.out.println(&quot;\n=== String Splitting ===&quot;);
String csvText = &quot;Java,Python,C++,JavaScript&quot;;
System.out.println(&quot;Original CSV: &quot; + csvText);
String[] languages = csvText.split(&quot;,&quot;);
System.out.println(&quot;After splitting:&quot;);
for (int i = 0; i &lt; languages.length; i++) {
System.out.println(&quot;Language &quot; + (i + 1) + &quot;: &quot; + languages[i]);
}
// String Building with StringBuilder
System.out.println(&quot;\n=== StringBuilder Demo ===&quot;);
StringBuilder builder = new StringBuilder();
builder.append(&quot;Learning &quot;);
builder.append(&quot;Java &quot;);
builder.append(&quot;Programming&quot;);
System.out.println(&quot;StringBuilder result: &quot; + builder.toString());
builder.insert(9, &quot;Core &quot;);
System.out.println(&quot;After insert: &quot; + builder.toString());
builder.reverse();
System.out.println(&quot;After reverse: &quot; + builder.toString());
// String Formatting
System.out.println(&quot;\n=== String Formatting ===&quot;);
String formatted = String.format(&quot;Name: %s, Age: %d, Height: %.2f&quot;, &quot;John&quot;, 25, 1.75);
System.out.println(&quot;Formatted string: &quot; + formatted);
// Checking String Properties
System.out.println(&quot;\n=== String Properties ===&quot;);
String testString = &quot;Java123&quot;;
System.out.println(&quot;Is empty: &quot; + testString.isEmpty());
System.out.println(&quot;Starts with &#39;Ja&#39;: &quot; + testString.startsWith(&quot;Ja&quot;));
System.out.println(&quot;Ends with &#39;123&#39;: &quot; + testString.endsWith(&quot;123&quot;));
// Practical Example: Email Validation
System.out.println(&quot;\n=== Practical Example: Email Validation ===&quot;);

String email = &quot;user@example.com&quot;;
boolean isValidEmail = validateEmail(email);
System.out.println(&quot;Email: &quot; + email);
System.out.println(&quot;Is valid: &quot; + isValidEmail);
}
// Helper method for email validation
private static boolean validateEmail(String email) {
// Basic email validation
return email != null &amp;&amp;
email.contains(&quot;@&quot;) &amp;&amp;
email.contains(&quot;.&quot;) &amp;&amp;
email.indexOf(&quot;@&quot;) &lt; email.lastIndexOf(&quot;.&quot;) &amp;&amp;
!email.startsWith(&quot;@&quot;) &amp;&amp;
!email.endsWith(&quot;.&quot;) &amp;&amp;
email.length() &gt;= 5;
}
}
