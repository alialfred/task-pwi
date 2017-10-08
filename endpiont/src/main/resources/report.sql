SELECT loc.Title AS Location, w.Title AS Warehouse, p.Title AS Item, pv.Title AS Size, 
SUM(frm.In_Stock) AS In_Stock, SUM(frm.In_Stock-frm.Supp_Order) AS Avl_Qty, SUM(frm.In_Transit) AS In_Transit,
wd.Min_Order_Qty AS MOQ, wd.Qty_Per_Box AS QPB, wd.Reorder_Point
FROM(
SELECT wo.Warehouse_Id, d.Product_Id, d.Product_Variation_Id AS Variation_Id, d.Qty AS In_Stock, 0 AS In_Transit, 0 AS Supp_Order 
FROM wh_opening_det d
LEFT JOIN wh_opening wo ON wo.Id = d.Wh_Opening_Id

UNION ALL

SELECT pv.Warehouse_Id, d.Product_Id, d.Product_Variation_Id AS Variation_Id, d.Quantity AS In_Stock, 0 AS In_Transit, 0 AS Supp_Order 
FROM purchase_det d
LEFT JOIN purchases pv ON pv.Id = d.Purchase_Id

UNION ALL

SELECT v.Warehouse_Id, d.Product_Id, d.Product_Variation_Id AS Variation_Id, -d.Quantity AS In_Stock, 0 AS In_Transit, 0 AS Supp_Order 
FROM supply_det d
LEFT JOIN supply v ON v.Id = d.Supply_Id

UNION ALL

SELECT v.Warehouse_Id, d.Product_Id, d.Product_Variation_Id AS Variation_Id, 0 AS In_Stock, d.Quantity AS In_Transit, 0 AS Supp_Order
FROM purchase_orders_det d
LEFT JOIN purchase_det pd ON pd.Order_Det_Id = d.Id AND pd.Product_Id = d.Product_Id AND pd.Product_Variation_Id = d.Product_Variation_Id 
LEFT JOIN purchase_orders v ON v.Id = d.Order_Id
WHERE pd.Id IS NULL 

UNION ALL

SELECT v.Warehouse_Id, d.Product_Id, d.Product_Variation_Id AS Variation_Id, 0 AS In_Stock, 0 AS In_Transit, d.Quantity AS Supp_Order  
FROM supply_orders_det d
LEFT JOIN supply_orders v ON v.Id = d.Order_Id
LEFT JOIN supply_det sd ON sd.Order_Det_Id = d.Id AND sd.Product_Id = d.Product_Id AND sd.Product_Variation_Id = d.Product_Variation_Id 
LEFT JOIN supply s ON s.Id = sd.Supply_Id
WHERE sd.Id IS NULL 

) frm, wh_vari wv, wh_vari_det wd, warehouses w, locations loc, products p, product_variations pv
WHERE frm.Warehouse_id = wv.Warehouse_Id AND wd.Wh_Vari_Id = wv.Id AND wd.Product_Id = frm.Product_Id AND wd.Product_Variation_Id = frm.Variation_Id
AND w.Id = frm.Warehouse_Id AND loc.Id = w.Location_Id AND p.Id = frm.Product_Id AND pv.Id = frm.Variation_Id
GROUP BY frm.Warehouse_Id, frm.Product_Id, frm.Variation_Id

