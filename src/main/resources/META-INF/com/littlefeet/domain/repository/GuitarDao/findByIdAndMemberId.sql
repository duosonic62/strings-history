select
  /*%expand*/*
from guitar
where id = /* id */'a'
  and member_id = /* memberId */'a'
  and is_deleted = false