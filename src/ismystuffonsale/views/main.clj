(ns ismystuffonsale.views.main
  (:use [hiccup core page]))

(defn index-page [data]
  (html5
    [:head
     [:title "Hello World"]]
    [:body
      [:ul
        (for [user data]
          [:li (str user)])]]))
