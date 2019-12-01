select
  /*%expand*/*
from guitar_string
where is_deleted = false
  /*%if name != null */
  and name like /* @infix(name) */'Eatrhwood'
  /*%end*/
  /*%if maker != null */
  and maker like /* @infix(maker) */'ERNIEBALL'
    /*%end*/
    /*%if thinGauge != null */
  and thin_gauge =/*thinGauge*/12
    /*%end*/
    /*%if thinGauge != null */
  and thick_gauge =/*thickGauge*/54
/*%end*/

