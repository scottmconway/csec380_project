from selenium.webdriver import Firefox
from selenium.webdriver.firefox.options import Options

options = Options()
options.add_argument('-headless')
firefox = Firefox(firefox_options=options)
firefox.get('http://localhost')