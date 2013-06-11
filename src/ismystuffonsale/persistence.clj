(ns ismystuffonsale.persistence
   (:use [korma.db]
         [korma.core]))

(defdb db (postgres {:db "ismystuffonsale"}))

(declare users email address state account posts)

(defentity items
  (belongs-to users))

(defentity users
  (has-many items))

(defn create-user [email]
  (insert users
    (values {:email email})))

(defn create-item [item]
  (let [user-id (get-in item [:user :id])]
    (insert items
      (values (merge {"users_id" user-id} (dissoc item :user))))))

(defn all-items []
  (select items))

(defn all-users []
  (select users
    (with items)))
