(ns config.migrate-config
  (:use [korma.db]
        [korma.core]))

(defdb db (postgres {:db "ismystuffonsale"}))

(defn- maybe-create-schema-table
  ([args] (maybe-create-schema-table))
  ([] (exec-raw "CREATE TABLE IF NOT EXISTS schema_version (version BIGINT NOT NULL, created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now())")))

(defn current-db-version []
  (maybe-create-schema-table)
  (or
    (:version
      (first
        (select :schema_version
                (fields :version)
                (order :created_at :DESC)
                (limit 1))))
    0))

(defn update-db-version [version]
  (insert :schema_version (values {:version version})))

(defn migrate-config []
  {:directory "/src/migrations"
   :ns-content "\n (:use [korma.db] [korma.core])"
   :namespace-prefix "migrations"
   :init maybe-create-schema-table
   :current-version current-db-version
   :update-version update-db-version })
