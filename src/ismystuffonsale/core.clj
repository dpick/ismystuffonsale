(ns ismystuffonsale.core
  (:use compojure.core)
  (:require [compojure.route :as route]
            [ismystuffonsale.persistence :as persistence]
            [ismystuffonsale.views.main :as main-views]
            [compojure.handler :as handler]))

(defn redirect-to
  "A shortcut for a '302 Moved' HTTP redirect."
  [location]
  {:status 302 :headers {"Location" location}})

(defn main-action [request]
  (main-views/index-page))

(defn create-action [request]
  (redirect-to "/"))

(defroutes main-routes
           (GET "/" [] main-action)
           (POST "/create" [] create-action)
           (route/not-found "<h1>Page not found</h1>"))

(def app
  (handler/site main-routes))
