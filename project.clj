(defproject ismystuffonsale "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-ring "0.7.1"]
            [drift "1.5.1"]]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [hiccup "1.0.0"]
                 [drift "1.5.1"]
                 [korma "0.3.0-RC5"]
                 [postgresql/postgresql "9.0-801.jdbc4"]
                 [compojure "1.1.5"]]
  :ring {:handler ismystuffonsale.core/app})
