select
  /*%expand*/*
from guitar
where member_id = /* memberId */'a'
  and is_deleted = false