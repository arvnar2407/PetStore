package com.pet.dbfw;

import java.sql.CallableStatement;
import java.sql.SQLException;

public interface OutTypeMapper {
void mapOutType(CallableStatement cStmt)
		throws SQLException;
}
