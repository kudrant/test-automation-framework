<p># test-automation-framework</p>
<p><strong>Google cloud pricing calculator test automation framework</strong></p>
<br>
<p>What is in the framework:</p>
<ul>
<li>Webdrivermanager for managing browser connectors</li>
<li>Page Object / Page Factory for page abstractions</li>
<li>Model for business objects of required entities</li>
<li>properties files with test data for different environments (at least 2)</li>
<li>xml suites for smoke tests and all tests</li>
<li>When the test fails, a screenshot with the date and time is saved</li>
<li>The framework has the ability to run with Jenkins and browser parameterization, test suite, environment.</li>
<li>Test results are displayed on the job graph, screenshots are archived as artifacts.</li>
</ul>
<br>
<p>Run from command line: <em>mvn -Dbrowser=chrome -Denvironment=dev -Dsurefire.suiteXmlFiles=src\test\resources\testng-smoke.xml clean test</em></p>
