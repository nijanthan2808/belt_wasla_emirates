-------- UPDATE ULD STATUS -------------------

--UPDATE ULD STATUS to Closed for ULD4457EK---
UPDATE T_ULDS SET ULD_STATUS='C' where ULD_NO = 'ULD4457EK' AND ULD_FLIGHT_NO = 'EK5441';

--UPDATE ULD STATUS to Positioned for ULD4459EK---
UPDATE T_ULDS SET ULD_STATUS='L' where ULD_NO = 'ULD4459EK' AND ULD_FLIGHT_NO = 'EK5441';

--UPDATE ULD STATUS to Dispatched for ULD4458EK---
UPDATE T_ULDS SET ULD_STATUS='D' where ULD_NO = 'ULD4458EK' AND ULD_FLIGHT_NO = 'EK5441';

--UPDATE ULD STATUS to DispatchedSTG for ULD4453EK---
UPDATE T_ULDS SET ULD_STATUS='S' where ULD_NO = 'ULD4453EK' AND ULD_FLIGHT_NO = 'EK5441';

--UPDATE ULD STATUS to Ramp for ULD4454EK---
UPDATE T_ULDS SET ULD_STATUS='R' where ULD_NO = 'ULD4454EK' AND ULD_FLIGHT_NO = 'EK5441';

COMMIT;