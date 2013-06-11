(ns ismystuffonsale.views.main
  (:use hiccup.core hiccup.form))

(defn index-page []
  (html5
    [:head
     [:title "Is My Stuff On Sale?"]]
    [:body
      [:h1 "Enter your email and an Amazon link and we'll let you know when that item goes on sale."]
      (form-to [:post "/create"]
        (label "email" "Email")
        (text-field "email")
        [:br]
        (label "url" "Amazon Link")
        (text-field "url")
        [:br]
        (submit-button "Submit"))]))
