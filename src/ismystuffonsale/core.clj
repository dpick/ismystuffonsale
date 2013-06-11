(ns ismystuffonsale.core
  (:use compojure.core)
  (:require [compojure.route :as route]
            [ismystuffonsale.persistence :as persistence]
            [ismystuffonsale.views.main :as main-views]
            [compojure.handler :as handler]))

(defn main-action [request]
  (main-views/index-page))

(defroutes main-routes
           (GET "/" [] main-action)
           (route/not-found "<h1>Page not found</h1>"))

(def app
  (handler/site main-routes))
