select
  /*%expand*/*
from guitar_string
where is_deleted = false
  /*%if name != null */
  and name like /* @contain(name) */'%X%' escape '$'
  /*%end*/
  /*%if maker != null */
  and maker like /* @contain(maker) */'%X%' escape '$'
    /*%end*/
    /*%if thinGauge != null */
    and thin_gauge =/*thinGauge*/10
    /*%end*/
    /*%if thinGauge != null */
    and thick_gauge =/*thinGauge*/46
/*%end*/

