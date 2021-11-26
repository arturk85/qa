@BDD
  Feature: Parameter tests

    @website1
    Scenario: Check title of website
      Given website has got title
      | website | http://wordpress.com |
      | title | strona powitalna wordpress |

      @website2
      Scenario: Check title of the website
        Given Name of the website "http://wordpress.com"
        Then Title if "strona wordpress haha"

#      Scenario Outline: Check website title
#        Given name of the website
#        Then title of website
#        Examples:
#        | website | title |
#        | http://wordpress.com | strona tytulowa |
#        | http://onet.pl  | google  |