#
# Description: Selenium test to make sure elastic is running on port 9200
# 
#
from selenium.webdriver import Firefox
from selenium.webdriver.firefox.options import Options

options = Options()
options.add_argument('-headless')
firefox = Firefox(firefox_options=options)
firefox.get('http://localhost:9200')