#
# Description: Test that a user is able to login with RIT LDAP credentials
# 
#
from selenium.webdriver import Firefox
from selenium.webdriver.firefox.options import Options

options = Options()
options.add_argument('-headless')
firefox = Firefox(firefox_options=options)
firefox.get('http://localhost:8089')